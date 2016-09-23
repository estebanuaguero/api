package org.yacare.bo.legal_guardian;

import java.util.ArrayList;
import java.util.List;

import org.utiljdbc.ConnectionWrapper;
import org.yacare.bo.AbstractBo;
import org.yacare.model.academic.student.legal_guardian.LegalGuardian;
import org.yacare.model.academic.student.legal_guardian.FamilyStudent;
import org.yacare.model.geo.Address;
import org.yacare.model.person.communication_options.email.Email;
import org.yacare.model.person.communication_options.phone.Phone;
import org.yacare.model.person.physical.Person;

public class LegalGuardianBo extends AbstractBo {

	private final String MSG_2 = "Error al tratar de obtener los datos del Tutor.";

	public LegalGuardian getLegalGuardianByPersonId(String personId) {

		ConnectionWrapper connectionWrapper = null;

		try {

			connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			// --------------------------------------------------------------------------------------------------------

			String sql = "SELECT * FROM yacare.f_legal_guardian_by_person_id(?);";

			LegalGuardian legalGuardian = (LegalGuardian) connectionWrapper
					.findToJsonById(sql, LegalGuardian.class, personId);

			if (legalGuardian != null) {
				// ----------------------------------

				sql = "SELECT * FROM yacare.f_main_address_person_by_person_id(?);";

				Address mainAddres = (Address) connectionWrapper
						.findToJsonById(sql, Address.class, personId);

				legalGuardian.getPersonalInformation()
						.getCommunicationOptions().getAddresses()
						.setMainAddress(mainAddres);

				// ----------------------------------

				sql = "SELECT * FROM yacare.f_alternative_addresses_person_by_person_id(?);";

				List<Object> list = connectionWrapper.findToJsonArray(sql,
						Address.class, personId);

				List<Address> alternativeAddresses = new ArrayList<Address>();

				for (Object o : list) {
					alternativeAddresses.add((Address) o);
				}

				legalGuardian.getPersonalInformation()
						.getCommunicationOptions().getAddresses()
						.setAlternativeAddresses(alternativeAddresses);

				// ----------------------------------

				sql = "SELECT * FROM yacare.f_main_email_person_by_person_id(?);";

				Email mainEmail = (Email) connectionWrapper.findToJsonById(sql,
						Email.class, personId);

				legalGuardian.getPersonalInformation()
						.getCommunicationOptions().getEmails()
						.setMainEmail(mainEmail);

				// ----------------------------------

				sql = "SELECT * FROM yacare.f_alternative_emails_person_by_person_id(?);";

				list = connectionWrapper.findToJsonArray(sql, Email.class,
						personId);

				List<Email> alternativeEmails = new ArrayList<Email>();

				for (Object o : list) {
					alternativeEmails.add((Email) o);
				}

				legalGuardian.getPersonalInformation()
						.getCommunicationOptions().getEmails()
						.setAlternativeEmails(alternativeEmails);

				// ----------------------------------

				sql = "SELECT * FROM yacare.f_main_phone_person_by_person_id(?);";

				Phone mainPhone = (Phone) connectionWrapper.findToJsonById(sql,
						Phone.class, personId);

				legalGuardian.getPersonalInformation()
						.getCommunicationOptions().getPhones()
						.setMainPhone(mainPhone);

				// ----------------------------------

				sql = "SELECT * FROM yacare.f_alternative_phones_person_by_person_id(?);";

				list = connectionWrapper.findToJsonArray(sql, Phone.class,
						personId);

				List<Phone> alternativePhones = new ArrayList<Phone>();

				for (Object o : list) {
					alternativePhones.add((Phone) o);
				}

				legalGuardian.getPersonalInformation()
						.getCommunicationOptions().getPhones()
						.setAlternativePhones(alternativePhones);

				// ----------------------------------

				sql = "SELECT * FROM yacare.f_legal_guardian_students(?);";

				list = connectionWrapper.findToJsonArray(sql,
						FamilyStudent.class, personId);

				List<FamilyStudent> students = new ArrayList<FamilyStudent>();

				for (Object o : list) {
					students.add((FamilyStudent) o);
				}

				legalGuardian.setStudents(students);

			}

			// --------------------------------------------------------------------------------------------------------			

			return legalGuardian;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);
		} finally {
			
			if(connectionWrapper != null){
				connectionWrapper.close();
			}
		}
	}

	public List<LegalGuardian> getLegalGuardians(Integer offset, Integer limit) {

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

			String sql = "SELECT * FROM yacare.f_legal_guardian(?,?);";

			List<Object> listO = connectionWrapper.findToJsonArray(sql,
					LegalGuardian.class, offset, limit);

			List<LegalGuardian> legalGuardians = new ArrayList<LegalGuardian>();

			for (Object obj : listO) {

				LegalGuardian legalGuardian = (LegalGuardian) obj;
				// ///////////////////////////////////////////////////////////

				if (legalGuardian != null) {

					Person personalInformation = legalGuardian
							.getPersonalInformation();

					String personId = personalInformation.getId();

					// ----------------------------------

					sql = "SELECT * FROM yacare.f_main_address_person_by_person_id(?);";

					Address mainAddres = (Address) connectionWrapper
							.findToJsonById(sql, Address.class, personId);

					legalGuardian.getPersonalInformation()
							.getCommunicationOptions().getAddresses()
							.setMainAddress(mainAddres);

					// ----------------------------------

					sql = "SELECT * FROM yacare.f_alternative_addresses_person_by_person_id(?);";

					List<Object> list = connectionWrapper.findToJsonArray(sql,
							Address.class, personId);

					List<Address> alternativeAddresses = new ArrayList<Address>();

					for (Object o : list) {
						alternativeAddresses.add((Address) o);
					}

					legalGuardian.getPersonalInformation()
							.getCommunicationOptions().getAddresses()
							.setAlternativeAddresses(alternativeAddresses);

					// ----------------------------------

					sql = "SELECT * FROM yacare.f_main_email_person_by_person_id(?);";

					Email mainEmail = (Email) connectionWrapper.findToJsonById(
							sql, Email.class, personId);

					legalGuardian.getPersonalInformation()
							.getCommunicationOptions().getEmails()
							.setMainEmail(mainEmail);

					// ----------------------------------

					sql = "SELECT * FROM yacare.f_alternative_emails_person_by_person_id(?);";

					list = connectionWrapper.findToJsonArray(sql, Email.class,
							personId);

					List<Email> alternativeEmails = new ArrayList<Email>();

					for (Object o : list) {
						alternativeEmails.add((Email) o);
					}

					legalGuardian.getPersonalInformation()
							.getCommunicationOptions().getEmails()
							.setAlternativeEmails(alternativeEmails);

					// ----------------------------------

					sql = "SELECT * FROM yacare.f_main_phone_person_by_person_id(?);";

					Phone mainPhone = (Phone) connectionWrapper.findToJsonById(
							sql, Phone.class, personId);

					legalGuardian.getPersonalInformation()
							.getCommunicationOptions().getPhones()
							.setMainPhone(mainPhone);

					// ----------------------------------

					sql = "SELECT * FROM yacare.f_alternative_phones_person_by_person_id(?);";

					list = connectionWrapper.findToJsonArray(sql, Phone.class,
							personId);

					List<Phone> alternativePhones = new ArrayList<Phone>();

					for (Object o : list) {
						alternativePhones.add((Phone) o);
					}

					legalGuardian.getPersonalInformation()
							.getCommunicationOptions().getPhones()
							.setAlternativePhones(alternativePhones);

				}

				// ///////////////////////////////////////////////////////////
				legalGuardians.add(legalGuardian);
			}

			// --------------------------------------------------------------------------------------------------------

			connectionWrapper.close();

			return legalGuardians;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);
		}
	}

}