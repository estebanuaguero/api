package org.yacare.bo.academic.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.cendra.commons.GeneralProperties;
import org.cendra.commons.ex.ErrorBussinessException;
import org.cendra.commons.utiljdbc.ConnectionWrapper;
import org.yacare.bo.AbstractBo;
import org.yacare.bo.person.physical.UtilPerson;
import org.yacare.model.academic.student.EmergencyContact;
import org.yacare.model.academic.student.FamilyLegalGuardian;
import org.yacare.model.academic.student.Student;

public class StudentBo extends AbstractBo {

	private GeneralProperties generalProperties;

	public GeneralProperties getGeneralProperties() {
		return generalProperties;
	}

	public void setGeneralProperties(GeneralProperties generalProperties) {
		this.generalProperties = generalProperties;
	}

	public byte[] getStudentPhotoByPersonId(String personId) {

		ConnectionWrapper connectionWrapper = null;

		try {

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			// --------------------------------------------------------------------------------------------------------

			// String sql = "SELECT * FROM yacare.f_student_by_person_id(?);";
			//
			// Student student = (Student) connectionWrapper.findToJsonById(sql,
			// Student.class, personId);
			//
			// completeData(student, connectionWrapper);

			// --------------------------------------------------------------------------------------------------------
			
			Properties properties = generalProperties.load();
			String path = generalProperties.getUrlFiles() + File.separatorChar + properties.get("url.data");

			return readBinary(path + File.separatorChar + "0a42c3af-60b4-44f6-a4ba-58231c2da7bc.png");

		} catch (Exception e) {

			e.printStackTrace();
			throw new ErrorBussinessException(this.getClass(),
					"Error al tratar de obtener la foto del estudiante.", e);
		} finally {

			connectionWrapper.close(connectionWrapper);
		}
	}

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
			throw new ErrorBussinessException(this.getClass(),
					"Error al tratar de obtener el estudiante.", e);
		} finally {

			connectionWrapper.close(connectionWrapper);
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
			throw new ErrorBussinessException(this.getClass(),
					"Error al tratar de obtener los estudiantes.", e);
		} finally {

			connectionWrapper.close(connectionWrapper);
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

				// ------------------------------------------------------------------------

				sql = "SELECT * FROM yacare.f_student_responsible_family(?);";

				list = connectionWrapper.findToJsonArray(sql,
						FamilyLegalGuardian.class, student
								.getPersonalInformation().getId());

				List<FamilyLegalGuardian> legalGuardians = new ArrayList<FamilyLegalGuardian>();

				for (Object o : list) {
					legalGuardians.add((FamilyLegalGuardian) o);
				}

				student.setLegalGuardians(legalGuardians);
			}

		}

	}

	private byte[] readBinary(String path) throws IOException {
		// path = path.replace('/', File.separatorChar);

		byte[] imgStream = null;

		FileInputStream in = new FileInputStream(path);

		imgStream = new byte[in.available()];

		in.read(imgStream);

		// Close it if we need to
		if (in != null)
			in.close();

		return imgStream;
	}

}
