package org.yacare.bo.user;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.CharEncoding;
import org.cendra.commons.GeneralProperties;
import org.cendra.commons.ex.BussinessAutenticationException;
import org.cendra.commons.ex.BussinessException;
import org.cendra.commons.ex.BussinessIllegalArgumentException;
import org.cendra.commons.ex.BussinessNotAvailableException;
import org.cendra.commons.ex.BussinessNotFoundException;
import org.cendra.commons.ex.ErrorBussinessException;
import org.cendra.commons.ex.ExNotFound;
import org.cendra.commons.ex.ExUnexpectedResult;
import org.cendra.commons.utiljdbc.ConnectionWrapper;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.yacare.bo.AbstractBo;
import org.yacare.bo.person.physical.UtilPerson;
import org.yacare.model.user.Token;
import org.yacare.model.user.User;
import org.yacare.model.user.UserAvaileability;

public class UserBo extends AbstractBo {

	// {
	// "userName":"14292837",
	// "password":"123",
	// "mainEmail":"dmansilla@unc.edu.ar"
	// }

	private MailSender mailSender;
	private GeneralProperties generalProperties;

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public GeneralProperties getGeneralProperties() {
		return generalProperties;
	}

	public void setGeneralProperties(GeneralProperties generalProperties) {
		this.generalProperties = generalProperties;
	}

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

			connectionWrapper.close(connectionWrapper);
		}
	}

	public UserAvaileability userAvaileability(String userName) {

		if (userName == null || userName.trim().length() == 0) {

			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió evaluar la disponibilidad de un usuario con nombre nulo, es decir su nombre de usuario está vacio.");
		}

		ConnectionWrapper connectionWrapper = null;

		try {

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			String sql = "SELECT * FROM yacare.f_legal_guardian_users_availeability_by_user_name(?);";

			UserAvaileability user = (UserAvaileability) connectionWrapper
					.findToJsonByExample(sql, UserAvaileability.class, userName);

			if (user == null) {
				throw new BussinessNotFoundException(this.getClass(),
						"No se encontro el tutor con nombre " + userName);
			} else if (user.getCheckEmail() == true) {
				throw new BussinessNotAvailableException(this.getClass(),
						"Ya existe un usuario (tutor) con nombre " + userName
								+ " y correo validado.");
			}

			// --------------------------------------------------------------------------------------------------------

			return user;

		} catch (Exception e) {

			e.printStackTrace();
			throw new ErrorBussinessException(this.getClass(),
					"Error al tratar de obtener los datos del usuario "
							+ userName, e);

		} finally {

			connectionWrapper.close(connectionWrapper);

		}
	}

	public void passwordsRecovery(String userName) {

		if (userName == null || userName.trim().length() == 0) {

			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió recuperar la contraseña de un usuario con nombre nulo, es decir su nombre de usuario está vacio.");
		}

		ConnectionWrapper connectionWrapper = null;

		try {

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			User user = utilGetLegalGuardianUsersByUserName(userName,
					connectionWrapper);

			if (user == null || user.getId() == null
					|| user.getId().trim().length() == 0) {

				throw new BussinessNotFoundException(this.getClass(),
						"No se encontro el usuario con nombre " + userName);
			}
			
			sendEmailPasswordsRecovery(user);

			// --------------------------------------------------------------------------------------------------------

		} catch (Exception e) {

			e.printStackTrace();
			throw new ErrorBussinessException(this.getClass(),
					"Error al tratar de recuperar la contraseña del usuario "
							+ userName, e);

		} finally {

			connectionWrapper.close(connectionWrapper);

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
						"No se encontro el usuario con nombre " + userName);
			}

			// --------------------------------------------------------------------------------------------------------

			return user;

		} catch (Exception e) {

			e.printStackTrace();
			throw new ErrorBussinessException(this.getClass(),
					"Error al tratar de obtener los datos del usuario "
							+ userName, e);

		} finally {

			connectionWrapper.close(connectionWrapper);

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
										+ user.getUserName() + ".");
					}

					sql = "INSERT INTO yacare.legal_guardian_user_token(id, legal_guardian_user_id) VALUES (?, ?);";

					Token token = new Token();
					token.setId(UUID.randomUUID().toString());

					r = connectionWrapper.update(sql, token.getId(),
							user.getId());

					if (r == 0) {
						throw new ExUnexpectedResult(this.getClass(),
								"No se pudo crear el usuario con nombre "
										+ user.getUserName()
										+ ". No se pudo crear su token. ");
					}

					user = utilGetLegalGuardianUsersByUserName(
							user.getUserName(), connectionWrapper);

					if (user == null || user.getId() == null
							|| user.getId().trim().length() == 0) {

						throw new ExUnexpectedResult(this.getClass(),
								"No se pudo crear el usuario con nombre "
										+ user.getUserName());
					}

					sendEmail(user);

				} else {

					throw new ExNotFound(this.getClass(),
							"No se pudo crear el usuario con nombre "
									+ user.getUserName()
									+ ". El tutor no existe.");
				}

			} else {
				throw new BussinessException(this.getClass(),
						"No se pudo crear el usuario con nombre "
								+ user.getUserName()
								+ ". El usuario ya existe.");
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

	public User updateLegalGuardianUser(User user) {

		if (user == null) {
			throw new BussinessIllegalArgumentException(this.getClass(),
					"Se pretendió actualizar un usuario nulo, es decir un usuario sin datos.");
		}

		if (user.getId() == null || user.getId().trim().length() == 0) {

			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió actualizar un usuario con id nulo, es decir su identificador de usuario está vacio.");
		}

		if (user.getUserName() == null
				|| user.getUserName().trim().length() == 0) {

			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió actualizar un usuario con nombre nulo, es decir su nombre de usuario está vacio.");
		}

		if (user.getPassword() == null
				|| user.getPassword().trim().length() == 0) {
			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió actualizar un usuario con contraseña nula, es decir su contraseña está vacia.");
		}

		if (user.getMainEmail() == null
				|| user.getMainEmail().trim().length() == 0) {
			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió actualizar un usuario con correo electrónico nulo, es decir su correo electrónico está vacio.");
		}

		ConnectionWrapper connectionWrapper = null;

		try {

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			connectionWrapper.begin();

			// --------------------------------------------------------------------------------------------------------

			if (userExists(user, connectionWrapper)) {

				String personId = user.getId();

				String sql = "UPDATE yacare.physical_person SET main_email = LOWER(TRIM(?)) WHERE id = ?";

				int r = connectionWrapper.update(sql, user.getMainEmail(),
						personId);

				if (r != 1) {
					throw new ExUnexpectedResult(this.getClass(),
							"No se pudo actualizar el correo electrónico del tutor (usuario con nombre "
									+ user.getUserName() + ").");
				}

				sql = "UPDATE yacare.legal_guardian_user SET password = TRIM(?) WHERE id = ?;";

				r = connectionWrapper.update(sql, user.getPassword(),
						user.getId());

				if (r == 0) {
					throw new ExUnexpectedResult(this.getClass(),
							"No se pudo actualizar el usuario con nombre "
									+ user.getUserName() + ".");
				}

				sql = "INSERT INTO yacare.legal_guardian_user_token(id, legal_guardian_user_id) VALUES (?, ?);";

				Token token = new Token();
				token.setId(UUID.randomUUID().toString());

				r = connectionWrapper.update(sql, token.getId(), user.getId());

				if (r == 0) {
					throw new ExUnexpectedResult(this.getClass(),
							"No se pudo actualizar el usuario con nombre "
									+ user.getUserName()
									+ ". No se pudo crear su token. ");
				}

				user = utilGetLegalGuardianUsersByUserName(user.getUserName(),
						connectionWrapper);

				if (user == null || user.getId() == null
						|| user.getId().trim().length() == 0) {

					throw new ExUnexpectedResult(this.getClass(),
							"No se pudo crear el usuario con nombre "
									+ user.getUserName());
				}

				sendEmail(user);

			} else {
				throw new BussinessException(this.getClass(),
						"No se pudo actualizar el usuario con nombre "
								+ user.getUserName()
								+ ". El usuario no existe.");
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

	public UserAvaileability updateLegalGuardianUserCheckEMail(String userName,
			String tokenId) {

		Token token = new Token();
		token.setId(tokenId);

		return updateLegalGuardianUserCheckEMail(userName, token);
	}

	public UserAvaileability updateLegalGuardianUserCheckEMail(String userName,
			Token token) {

		if (userName == null || userName.trim().length() == 0) {

			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió validar el correo de un usuario con nombre nulo, es decir su nombre de usuario está vacio.");
		}

		if (token == null) {
			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió validar el correo de un usuario con un token nulo, es decir un token sin datos.");
		}

		if (token.getId() == null || token.getId().trim().length() == 0) {

			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió validar el correo de un usuario con un token nulo, es decir su identificador de token está vacio.");
		}

		ConnectionWrapper connectionWrapper = null;

		try {

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			connectionWrapper.begin();

			// --------------------------------------------------------------------------------------------------------

			String sql = "SELECT * FROM yacare.f_legal_guardian_users_token_availeability_by_user_name(?, ?);";

			UserAvaileability user = (UserAvaileability) connectionWrapper
					.findToJsonByExample(sql, UserAvaileability.class,
							userName, token.getId());

			if (user != null && user.getId() != null
					&& user.getId().trim().length() > 0) {

				if (user.getCheckEmail() != null
						&& user.getCheckEmail() == true) {
					throw new BussinessException(
							this.getClass(),
							"Se pretendió validar el correo de un usuario, cuando éste ya esta validado, es decir el usuario ya fue creado y validado. Nombre de usuario "
									+ user.getUserName());
				}

				sql = "UPDATE yacare.legal_guardian_user SET validate_email = true WHERE id = ?";

				int r = connectionWrapper.update(sql, user.getId());

				if (r != 1) {
					throw new ExUnexpectedResult(
							this.getClass(),
							"No se pudo actualizar el usuario para setear que el correo se validó, (usuario con nombre "
									+ user.getUserName() + ").");
				}

				sql = "UPDATE yacare.legal_guardian_user_token SET used = true WHERE id = ?;";

				r = connectionWrapper.update(sql, token.getId());

				if (r == 0) {
					throw new ExUnexpectedResult(
							this.getClass(),
							"No se pudo actualizar el usuario para setear que el correo se validó, (usuario con nombre "
									+ user.getUserName()
									+ "). No se pudo setear que e token se utilizó.");
				}

				sql = "SELECT * FROM yacare.f_legal_guardian_users_token_availeability_by_user_name(?, ?);";

				user = (UserAvaileability) connectionWrapper
						.findToJsonByExample(sql, UserAvaileability.class,
								userName, token.getId());

				if (user == null || user.getId() == null
						|| user.getId().trim().length() == 0
						|| user.getCheckEmail() == false) {

					throw new BussinessException(this.getClass(),
							"No se pudo validar el correo el usuario con nombre "
									+ user.getUserName()
									+ ". El usuario no existe.");
				}

				if (user.getCheckEmail() == false) {

					throw new ExUnexpectedResult(
							this.getClass(),
							"No se pudo actualizar el usuario para setear que el correo se validó, (usuario con nombre "
									+ user.getUserName() + ").");
				}

				// sendEmail(user);

			} else {
				throw new BussinessException(this.getClass(),
						"No se pudo validar el correo el usuario con nombre "
								+ userName + ". El usuario no existe.");
			}

			// --------------------------------------------------------------------------------------------------------

			connectionWrapper.commit();

			return user;

		} catch (Exception e) {

			connectionWrapper.rollBack();
			e.printStackTrace();
			throw new ErrorBussinessException(this.getClass(),
					"No se pudo crear el usuario con nombre " + userName, e);

		} finally {
			connectionWrapper.close(connectionWrapper);
		}

	}

	public User login(String userName, String password){
		
		if (userName == null || userName.trim().length() == 0) {

			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió autenticar un usuario con nombre nulo, es decir su nombre de usuario está vacio.");
		}
		
		if (password == null || password.trim().length() == 0) {

			throw new BussinessIllegalArgumentException(
					this.getClass(),
					"Se pretendió autenticar un usuario con password nulo, es decir su contraseña de usuario está vacia.");
		}
		
		userName = userName.trim();
		password = password.trim();

		ConnectionWrapper connectionWrapper = null;

		try {

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			User user = utilGetLegalGuardianUsersByUserName(userName,
					connectionWrapper);

			if (user == null || user.getId() == null
					|| user.getId().trim().length() == 0) {

				throw new BussinessAutenticationException(this.getClass(),
						"El nombre de " + userName + " es incorrecto.");
			}
			
			if(password.equals(user.getPassword())){
				return user;
			}
			
			throw new BussinessAutenticationException(this.getClass(),
					"El password " + password + " no pertenece al usuario "+ userName);
			
			// --------------------------------------------------------------------------------------------------------

		} catch (Exception e) {

			e.printStackTrace();
			throw new ErrorBussinessException(this.getClass(),
					"Error al tratar de recuperar la contraseña del usuario "
							+ userName, e);

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

	private void sendEmail(User user) throws Exception {

		String tokenValue = user.getTokens().get(user.getTokens().size() - 1)
				.getId();

		String name = "";
		String lastName = "";

		if (user.getPersonalInformation().getGivenNames() != null
				&& user.getPersonalInformation().getGivenNames().size() > 0) {
			name = user.getPersonalInformation().getGivenNames().get(0);
		}

		if (user.getPersonalInformation().getSurnames() != null
				&& user.getPersonalInformation().getSurnames().size() > 0) {
			lastName = user.getPersonalInformation().getSurnames().get(0);
		}

		String names = name + " " + lastName;
		names = names.trim();

		if (mailSender instanceof JavaMailSenderImpl) {

			// JavaMailSenderImpl jmailSender = new JavaMailSenderImpl();
			JavaMailSenderImpl jmailSender = (JavaMailSenderImpl) this.mailSender;

			Properties properties = generalProperties.load();

			jmailSender.setJavaMailProperties(properties);

			MimeMessage mime = jmailSender.createMimeMessage();

			// String subject = MimeUtility.encodeText(properties.get(
			// "post.guardian_users.send.subject.email").toString(), "UTF-8",
			// "Q");

			mime.setHeader("Content-Type", "text/plain; charset=UTF-8");

			mime.setSubject(
					properties.get("post.guardian_users.send.subject.email")
							.toString(), "UTF8");

			// MimeMessageHelper helper = new MimeMessageHelper(mime, true,
			// "UTF-8");
			MimeMessageHelper helper = new MimeMessageHelper(mime, true,
					CharEncoding.UTF_8);
			helper.setFrom(properties.get("send.from.email").toString());
			helper.setTo(user.getMainEmail());

			// helper.setSubject(subject);

			String htmlText = generalProperties
					.readFilePlainText(generalProperties.getUrlFiles()
							+ File.separatorChar
							+ properties.get(
									"post.guardian_users.send.body.email")
									.toString());

			htmlText = htmlText.replace("${names}", names);
			htmlText = htmlText.replace("${userName}", user.getUserName());
			htmlText = htmlText.replace("${token}", tokenValue);

			helper.setText(htmlText, true);
			//
			// helper.addAttachment(
			// "cnm.png",
			// new File(
			// generalProperties.getUrlFiles()
			// + File.separatorChar
			// + properties
			// .get("post.guardian_users.send.body.logo.email")));

			jmailSender.send(mime);

		}
	}

	private void sendEmailPasswordsRecovery(User user) throws Exception {

		String name = "";
		String lastName = "";

		if (user.getPersonalInformation().getGivenNames() != null
				&& user.getPersonalInformation().getGivenNames().size() > 0) {
			name = user.getPersonalInformation().getGivenNames().get(0);
		}

		if (user.getPersonalInformation().getSurnames() != null
				&& user.getPersonalInformation().getSurnames().size() > 0) {
			lastName = user.getPersonalInformation().getSurnames().get(0);
		}

		String names = name + " " + lastName;
		names = names.trim();

		if (mailSender instanceof JavaMailSenderImpl) {

			JavaMailSenderImpl jmailSender = (JavaMailSenderImpl) this.mailSender;

			Properties properties = generalProperties.load();

			jmailSender.setJavaMailProperties(properties);

			MimeMessage mime = jmailSender.createMimeMessage();

			mime.setHeader("Content-Type", "text/plain; charset=UTF-8");

			mime.setSubject(
					properties
							.get("post.guardian_users.send.subject.email_passwords_recovery")
							.toString(), "UTF8");

			MimeMessageHelper helper = new MimeMessageHelper(mime, true,
					CharEncoding.UTF_8);
			helper.setFrom(properties.get("send.from.email").toString());
			helper.setTo(user.getMainEmail());

			String htmlText = generalProperties
					.readFilePlainText(generalProperties.getUrlFiles()
							+ File.separatorChar
							+ properties
									.get("post.guardian_users.send.body.email_passwords_recovery")
									.toString());

			htmlText = htmlText.replace("${names}", names);
			htmlText = htmlText.replace("${userName}", user.getUserName());
			htmlText = htmlText.replace("${password}", user.getPassword());

			helper.setText(htmlText, true);

			jmailSender.send(mime);
		}
	}



	
	
} // END CLASS
