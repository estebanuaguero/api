package org.yacare.bo.academic.student;

import java.util.ArrayList;
import java.util.List;

import org.utiljdbc.ConnectionWrapper;
import org.yacare.bo.AbstractBo;
import org.yacare.model.academic.student.EmergencyContact;
import org.yacare.model.academic.student.FamilyLegalGuardian;
import org.yacare.model.academic.student.Student;
import org.yacare.model.academic.student.annual_enrollment.AnnualEnrollment;
import org.yacare.model.geo.Address;
import org.yacare.model.person.communication_options.email.Email;
import org.yacare.model.person.communication_options.phone.Phone;
import org.yacare.model.person.physical.Person;

public class StudentBo extends AbstractBo {

	private final String MSG_2 = "Error al tratar de obtener los datos del Estudiante.";

	public Student getStudentByPersonId(String personId) {

		ConnectionWrapper connectionWrapper = null;

		try {

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			// --------------------------------------------------------------------------------------------------------

			String sql = "SELECT * FROM yacare.f_student_by_person_id(?);";

			Student student = (Student) connectionWrapper.findToJsonById(sql,
					Student.class, personId);

			if (student != null) {
				// ----------------------------------

				sql = "SELECT * FROM yacare.f_main_address_person_by_person_id(?);";

				Address mainAddres = (Address) connectionWrapper
						.findToJsonById(sql, Address.class, personId);

				student.getPersonalInformation().getCommunicationOptions()
						.getAddresses().setMainAddress(mainAddres);

				// ----------------------------------

				sql = "SELECT * FROM yacare.f_alternative_addresses_person_by_person_id(?);";

				List<Object> list = connectionWrapper.findToJsonArray(sql,
						Address.class, personId);

				List<Address> alternativeAddresses = new ArrayList<Address>();

				for (Object o : list) {
					alternativeAddresses.add((Address) o);
				}

				student.getPersonalInformation().getCommunicationOptions()
						.getAddresses()
						.setAlternativeAddresses(alternativeAddresses);

				// ----------------------------------

				sql = "SELECT * FROM yacare.f_main_email_person_by_person_id(?);";

				Email mainEmail = (Email) connectionWrapper.findToJsonById(sql,
						Email.class, personId);

				student.getPersonalInformation().getCommunicationOptions()
						.getEmails().setMainEmail(mainEmail);

				// ----------------------------------

				sql = "SELECT * FROM yacare.f_alternative_emails_person_by_person_id(?);";

				list = connectionWrapper.findToJsonArray(sql, Email.class,
						personId);

				List<Email> alternativeEmails = new ArrayList<Email>();

				for (Object o : list) {
					alternativeEmails.add((Email) o);
				}

				student.getPersonalInformation().getCommunicationOptions()
						.getEmails().setAlternativeEmails(alternativeEmails);

				// ----------------------------------

				sql = "SELECT * FROM yacare.f_main_phone_person_by_person_id(?);";

				Phone mainPhone = (Phone) connectionWrapper.findToJsonById(sql,
						Phone.class, personId);

				student.getPersonalInformation().getCommunicationOptions()
						.getPhones().setMainPhone(mainPhone);

				// ----------------------------------

				sql = "SELECT * FROM yacare.f_alternative_phones_person_by_person_id(?);";

				list = connectionWrapper.findToJsonArray(sql, Phone.class,
						personId);

				List<Phone> alternativePhones = new ArrayList<Phone>();

				for (Object o : list) {
					alternativePhones.add((Phone) o);
				}

				student.getPersonalInformation().getCommunicationOptions()
						.getPhones().setAlternativePhones(alternativePhones);

				// ----------------------------------

				sql = "SELECT * FROM yacare.f_student_responsible_family(?);";

				list = connectionWrapper.findToJsonArray(sql,
						FamilyLegalGuardian.class, personId);

				List<FamilyLegalGuardian> legalGuardians = new ArrayList<FamilyLegalGuardian>();

				for (Object o : list) {
					legalGuardians.add((FamilyLegalGuardian) o);
				}

				student.setLegalGuardians(legalGuardians);
				
				// ----------------------------------

				sql = "SELECT * FROM yacare.f_emergency_contacts_by_person_id(?);";

				list = connectionWrapper.findToJsonArray(sql,
						EmergencyContact.class, personId);

				List<EmergencyContact> emergencyContacts = new ArrayList<EmergencyContact>();

				for (Object o : list) {
					emergencyContacts.add((EmergencyContact) o);
				}

				student.setEmergencyContacts(emergencyContacts);

			}

			// --------------------------------------------------------------------------------------------------------

			return student;

		} catch (Exception e) {
			 e.printStackTrace();
			throw new RuntimeException(MSG_2);

		} finally {

			if (connectionWrapper != null) {

				connectionWrapper.close();
			}
		}
	}

	public List<Student> getStudents(Integer offset, Integer limit) {

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

			ConnectionWrapper connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			// --------------------------------------------------------------------------------------------------------

			String sql = "SELECT * FROM yacare.f_student(?,?);";

			List<Object> listO = connectionWrapper.findToJsonArray(sql,
					Student.class, offset, limit);

			List<Student> students = new ArrayList<Student>();

			for (Object obj : listO) {

				Student student = (Student) obj;
				// ///////////////////////////////////////////////////////////

				if (student != null) {

					Person personalInformation = student
							.getPersonalInformation();

					String personId = personalInformation.getId();

					// ----------------------------------

					sql = "SELECT * FROM yacare.f_main_address_person_by_person_id(?);";

					Address mainAddres = (Address) connectionWrapper
							.findToJsonById(sql, Address.class, personId);

					student.getPersonalInformation().getCommunicationOptions()
							.getAddresses().setMainAddress(mainAddres);

					// ----------------------------------

					sql = "SELECT * FROM yacare.f_alternative_addresses_person_by_person_id(?);";

					List<Object> list = connectionWrapper.findToJsonArray(sql,
							Address.class, personId);

					List<Address> alternativeAddresses = new ArrayList<Address>();

					for (Object o : list) {
						alternativeAddresses.add((Address) o);
					}

					student.getPersonalInformation().getCommunicationOptions()
							.getAddresses()
							.setAlternativeAddresses(alternativeAddresses);

					// ----------------------------------

					sql = "SELECT * FROM yacare.f_main_email_person_by_person_id(?);";

					Email mainEmail = (Email) connectionWrapper.findToJsonById(
							sql, Email.class, personId);

					student.getPersonalInformation().getCommunicationOptions()
							.getEmails().setMainEmail(mainEmail);

					// ----------------------------------

					sql = "SELECT * FROM yacare.f_alternative_emails_person_by_person_id(?);";

					list = connectionWrapper.findToJsonArray(sql, Email.class,
							personId);

					List<Email> alternativeEmails = new ArrayList<Email>();

					for (Object o : list) {
						alternativeEmails.add((Email) o);
					}

					student.getPersonalInformation().getCommunicationOptions()
							.getEmails()
							.setAlternativeEmails(alternativeEmails);

					// ----------------------------------

					sql = "SELECT * FROM yacare.f_main_phone_person_by_person_id(?);";

					Phone mainPhone = (Phone) connectionWrapper.findToJsonById(
							sql, Phone.class, personId);

					student.getPersonalInformation().getCommunicationOptions()
							.getPhones().setMainPhone(mainPhone);

					// ----------------------------------

					sql = "SELECT * FROM yacare.f_alternative_phones_person_by_person_id(?);";

					list = connectionWrapper.findToJsonArray(sql, Phone.class,
							personId);

					List<Phone> alternativePhones = new ArrayList<Phone>();

					for (Object o : list) {
						alternativePhones.add((Phone) o);
					}

					student.getPersonalInformation().getCommunicationOptions()
							.getPhones()
							.setAlternativePhones(alternativePhones);
					
					
					// ----------------------------------
					
					sql = "SELECT * FROM yacare.f_emergency_contacts_by_person_id(?);";

					list = connectionWrapper.findToJsonArray(sql,
							EmergencyContact.class, personId);

					List<EmergencyContact> emergencyContacts = new ArrayList<EmergencyContact>();

					for (Object o : list) {
						emergencyContacts.add((EmergencyContact) o);
					}

					student.setEmergencyContacts(emergencyContacts);


				}

				// ///////////////////////////////////////////////////////////
				students.add(student);
			}

			// --------------------------------------------------------------------------------------------------------

			connectionWrapper.close();

			return students;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);
		}
	}
	
	public List<AnnualEnrollment> getAnnualEnrollments(String studentId, Boolean lastAdmission) {

		try {			

			ConnectionWrapper connectionWrapper = this.getDataSourceWrapper()
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

			connectionWrapper.close();

			return annualEnrollments;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);
		}
	}

}
