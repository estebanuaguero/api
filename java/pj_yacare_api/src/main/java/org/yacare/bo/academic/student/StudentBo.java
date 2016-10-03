package org.yacare.bo.academic.student;

import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.utiljdbc.ConnectionWrapper;
import org.yacare.bo.AbstractBo;
import org.yacare.bo.person.physical.UtilPerson;
import org.yacare.model.academic.student.EmergencyContact;
import org.yacare.model.academic.student.Student;
import org.yacare.model.academic.student.annual_enrollment.AnnualEnrollment;

public class StudentBo extends AbstractBo {

	private final String MSG_1 = "Error al tratar de obtener los datos del estudiante con identificador  ";
	private final String MSG_2 = "Error al tratar de obtener los estudiantes.";

	public Student getStudentByPersonId(String personId) {

		ConnectionWrapper connectionWrapper = null;

		try {

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			// --------------------------------------------------------------------------------------------------------

			String sql = "SELECT * FROM yacare.f_student_by_person_id(?);";

			Student student = (Student) connectionWrapper.findToJsonById(sql,
					Student.class, personId);

			completeData(student, connectionWrapper);

			// --------------------------------------------------------------------------------------------------------

			return student;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_1 + personId);

		} finally {

			if (connectionWrapper != null) {

				connectionWrapper.close();
			}
		}
	}

	public List<Student> getStudents(Integer offset, Integer limit) {

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

			String sql = "SELECT * FROM yacare.f_student(?,?);";

			List<Object> listO = connectionWrapper.findToJsonArray(sql,
					Student.class, offset, limit);

			List<Student> students = new ArrayList<Student>();

			for (Object obj : listO) {

				Student student = (Student) obj;

				completeData(student, connectionWrapper);

				students.add(student);
			}

			// --------------------------------------------------------------------------------------------------------

			return students;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);

		} finally {

			if (connectionWrapper != null) {

				connectionWrapper.close();
			}
		}
	}

	public List<AnnualEnrollment> getAnnualEnrollments(String studentId,
			Boolean lastAdmission) {

		ConnectionWrapper connectionWrapper = null;

		try {

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			// --------------------------------------------------------------------------------------------------------

			String sql = "SELECT * FROM yacare.f_student(?,?);";

			List<Object> listO = connectionWrapper.findToJsonArray(sql,
					AnnualEnrollment.class);

			List<AnnualEnrollment> annualEnrollments = new ArrayList<AnnualEnrollment>();

			for (Object obj : listO) {

				AnnualEnrollment annualEnrollment = (AnnualEnrollment) obj;

				annualEnrollments.add(annualEnrollment);
			}

			// --------------------------------------------------------------------------------------------------------

			return annualEnrollments;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);

		} finally {

			if (connectionWrapper != null) {

				connectionWrapper.close();
			}
		}
	}

	private void completeData(Student student,
			ConnectionWrapper connectionWrapper) {

		if (student != null) {

			new UtilPerson().completeData(student.getPersonalInformation(),
					connectionWrapper);

			if (student.getPersonalInformation() != null
					&& student.getPersonalInformation().getId() != null
					&& student.getPersonalInformation().getId().trim().length() > 0) {

				String sql = "SELECT * FROM yacare.f_emergency_contacts_by_person_id(?);";

				List<Object> list = connectionWrapper.findToJsonArray(sql,
						EmergencyContact.class, student
								.getPersonalInformation().getId());

				List<EmergencyContact> emergencyContacts = new ArrayList<EmergencyContact>();

				for (Object o : list) {
					emergencyContacts.add((EmergencyContact) o);
				}

				student.setEmergencyContacts(emergencyContacts);
			}

		}

	}

}
