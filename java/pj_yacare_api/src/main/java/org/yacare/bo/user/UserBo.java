package org.yacare.bo.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.cendra.commons.ex.BussinessException;
import org.cendra.commons.ex.BussinessIllegalArgumentException;
import org.cendra.commons.ex.BussinessNotFoundException;
import org.cendra.commons.ex.ErrorBussinessException;
import org.cendra.commons.utiljdbc.ConnectionWrapper;
import org.cendra.commons.utiljdbc.ex.ExUnexpectedResult;
import org.yacare.bo.AbstractBo;
import org.yacare.bo.person.physical.UtilPerson;
import org.yacare.model.user.Token;
import org.yacare.model.user.User;

public class UserBo extends AbstractBo {

	public List<User> getLegalGuardianUsers(Integer offset, Integer limit) {

		ConnectionWrapper connectionWrapper = null;

		try {

			if (offset == null) {
				offset = 0;
			}
			if (limit == null) {
				limit = 5;
			}

			if (limit > 100) {
				limit = 100;
			}

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			// --------------------------------------------------------------------------------------------------------

			String sql = "SELECT * FROM yacare.f_legal_guardian_users(?, ?);";

			List<Object> list = connectionWrapper.findToJsonArray(sql,
					User.class, offset, limit);

			List<User> users = new ArrayList<User>();

			for (Object o : list) {
				completeData((User) o, connectionWrapper);
				users.add((User) o);
			}

			// --------------------------------------------------------------------------------------------------------

			return users;

		} catch (Exception e) {

			e.printStackTrace();
			throw new ErrorBussinessException(this.getClass(),
					"Error al tratar de obtener los usuarios.", e);
		} finally {

			if (connectionWrapper != null) {
				connectionWrapper.close();
			}
		}
	}

	public User getLegalGuardianUsersByUserName(String userName) {

		ConnectionWrapper connectionWrapper = null;

		try {

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			User user = utilGetLegalGuardianUsersByUserName(userName,
					connectionWrapper);

			if (user == null || user.getId() == null
					|| user.getId().trim().length() == 0) {

				throw new BussinessNotFoundException(this.getClass(),
						"No se encontrol el usuario con nombre "
								+ user.getUserName());
			}

			// --------------------------------------------------------------------------------------------------------

			return user;

		} catch (Exception e) {

			e.printStackTrace();
			throw new ErrorBussinessException(this.getClass(),
					"Error al tratar de obtener los datos del usuario "
							+ userName, e);

		} finally {

			if (connectionWrapper != null) {
				connectionWrapper.close();
			}

		}
	}

	public User createLegalGuardianUser(User user) {

		if (user == null) {
			throw new BussinessIllegalArgumentException(this.getClass(),
					"Se pretendió crear un usuario nulo, es decir un usuario sin datos.");
		}

		if (user.getId() != null) {
			throw new BussinessIllegalArgumentException(this.getClass(),
					"Se pretendió crear un usuario que ya tiene identificador, id = "
							+ user.getId());
		}

		if (user.getUserName() == null
				|| user.getUserName().trim().length() == 0) {

			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió crear un usuario con nombre nulo, es decir su nombre de usuario está vacio.");
		}

		if (user.getPassword() == null
				|| user.getPassword().trim().length() == 0) {
			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió crear un usuario con contraseña nula, es decir su contraseña está vacia.");
		}

		if (user.getMainEmail() == null
				|| user.getMainEmail().trim().length() == 0) {
			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió crear un usuario con correo electrónico nulo, es decir su correo electrónico está vacio.");
		}

		ConnectionWrapper connectionWrapper = null;

		try {

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			connectionWrapper.begin();

			// --------------------------------------------------------------------------------------------------------

			if (userExists(user, connectionWrapper) == false) {

				String personId = null;

				String sql = "SELECT id, identification_number FROM yacare.physical_person WHERE LOWER(TRIM(identification_number)) = LOWER(TRIM(?))";
				Object[][] t = connectionWrapper.findToTable(sql,
						user.getUserName());

				if (t != null && t.length > 0 && t[0].length > 0
						&& t[0][0] != null) {

					personId = t[0][0].toString();

					sql = "UPDATE yacare.physical_person SET main_email = LOWER(TRIM(?)) WHERE id = ?";

					int r = connectionWrapper.update(sql, user.getMainEmail(),
							personId);

					if (r != 1) {
						throw new ExUnexpectedResult(this.getClass(),
								"No se pudo actualizar el correo electrónico del tutor (usuario con nombre "
										+ user.getUserName() + ").");
					}

					user.setId(personId);

					sql = "INSERT INTO yacare.legal_guardian_user(id, password, physical_person_id) VALUES (?, ?, ?);";

					r = connectionWrapper.update(sql, user.getId(),
							user.getPassword(), user.getId());

					if (r == 0) {
						throw new ExUnexpectedResult(this.getClass(),
								"No se pudo crear el usuario con nombre "
										+ user.getUserName() + ").");
					}

					sql = "INSERT INTO yacare.legal_guardian_user_token(id, legal_guardian_user_id) VALUES (?, ?, ?);";

					Token token = new Token();
					token.setId(UUID.randomUUID().toString());

					r = connectionWrapper.update(sql, token.getId(),
							user.getId());

					if (r == 0) {
						throw new ExUnexpectedResult(this.getClass(),
								"No se pudo crear el usuario con nombre "
										+ user.getUserName()
										+ "). No se pudo crear su token. ");
					}

					// mandar el mail

				} else {

					throw new ExUnexpectedResult(this.getClass(),
							"No se pudo crear el usuario con nombre "
									+ user.getUserName()
									+ "). El tutor no existe.");
				}

			} else {
				throw new BussinessException(this.getClass(),
						"No se pudo crear el usuario con nombre "
								+ user.getUserName()
								+ "). El usuario ya existe.");
			}

			user = utilGetLegalGuardianUsersByUserName(user.getUserName(),
					connectionWrapper);

			if (user == null || user.getId() == null
					|| user.getId().trim().length() == 0) {

				throw new ExUnexpectedResult(this.getClass(),
						"No se pudo crear el usuario con nombre "
								+ user.getUserName());
			}

			// --------------------------------------------------------------------------------------------------------

			connectionWrapper.commit();

			return user;

		} catch (Exception e) {

			connectionWrapper.rollBack();
			e.printStackTrace();
			throw new ErrorBussinessException(this.getClass(),
					"No se pudo crear el usuario con nombre "
							+ user.getUserName(), e);

		} finally {
			connectionWrapper.close(connectionWrapper);
		}

	}

	private boolean userExists(User user, ConnectionWrapper connectionWrapper) {

		return userExists(user.getUserName(), connectionWrapper);
	}

	private boolean userExists(String userName,
			ConnectionWrapper connectionWrapper) {

		String sql = "SELECT * FROM yacare.f_legal_guardian_users_by_user_name(?);";

		User user = (User) connectionWrapper.findToJsonByExample(sql,
				User.class, userName);

		return (user != null && user.getId() != null && user.getId().trim()
				.length() > 0);
	}

	private void completeData(User user, ConnectionWrapper connectionWrapper) {

		if (user != null) {

			new UtilPerson().completeData(user.getPersonalInformation(),
					connectionWrapper);

		}

	}

	private User utilGetLegalGuardianUsersByUserName(String userName,
			ConnectionWrapper connectionWrapper) {

		if (userName == null || userName.trim().length() == 0) {

			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió buscar un usuario con nombre nulo, es decir con su nombre de usuario vacio.");
		}

		// --------------------------------------------------------------------------------------------------------

		String sql = "SELECT * FROM yacare.f_legal_guardian_users_by_user_name(?);";

		User user = (User) connectionWrapper.findToJsonByExample(sql,
				User.class, userName);

		completeData(user, connectionWrapper);

		return user;
	}

}
