package org.yacare.bo.legal_guardian;

import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.utiljdbc.ConnectionWrapper;
import org.yacare.bo.AbstractBo;
import org.yacare.bo.person.physical.UtilPerson;
import org.yacare.model.academic.student.legal_guardian.FamilyStudent;
import org.yacare.model.academic.student.legal_guardian.LegalGuardian;

public class LegalGuardianBo extends AbstractBo {

	private final String MSG_1 = "Error al tratar de obtener los datos del tutor con identificador  ";
	private final String MSG_2 = "Error al tratar de obtener los tutores.";

	public LegalGuardian getLegalGuardianByPersonId(String personId) {

		ConnectionWrapper connectionWrapper = null;

		try {

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			// --------------------------------------------------------------------------------------------------------

			String sql = "SELECT * FROM yacare.f_legal_guardian_by_person_id(?);";

			LegalGuardian legalGuardian = (LegalGuardian) connectionWrapper
					.findToJsonById(sql, LegalGuardian.class, personId);

			completeData(legalGuardian, connectionWrapper);

			// --------------------------------------------------------------------------------------------------------

			return legalGuardian;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_1 + personId);
		} finally {

			if (connectionWrapper != null) {
				connectionWrapper.close();
			}
		}
	}

	public List<LegalGuardian> getLegalGuardians(Integer offset, Integer limit) {

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

			String sql = "SELECT * FROM yacare.f_legal_guardian(?,?);";

			List<Object> listO = connectionWrapper.findToJsonArray(sql,
					LegalGuardian.class, offset, limit);

			List<LegalGuardian> legalGuardians = new ArrayList<LegalGuardian>();

			for (Object obj : listO) {

				LegalGuardian legalGuardian = (LegalGuardian) obj;

				completeData(legalGuardian, connectionWrapper);

				legalGuardians.add(legalGuardian);
			}

			// --------------------------------------------------------------------------------------------------------

			return legalGuardians;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);
		} finally {

			if (connectionWrapper != null) {
				connectionWrapper.close();
			}
		}
	}

	private void completeData(LegalGuardian legalGuardian,
			ConnectionWrapper connectionWrapper) {

		if (legalGuardian != null) {

			new UtilPerson().completeData(
					legalGuardian.getPersonalInformation(), connectionWrapper);

			if (legalGuardian.getPersonalInformation() != null
					&& legalGuardian.getPersonalInformation().getId() != null
					&& legalGuardian.getPersonalInformation().getId().trim()
							.length() > 0) {

				String sql = "SELECT * FROM yacare.f_legal_guardian_students(?);";

				List<Object> list = connectionWrapper.findToJsonArray(sql,
						FamilyStudent.class, legalGuardian
								.getPersonalInformation().getId());

				List<FamilyStudent> students = new ArrayList<FamilyStudent>();

				for (Object o : list) {
					students.add((FamilyStudent) o);
				}

				legalGuardian.setStudents(students);

			}

		}

	}

}
