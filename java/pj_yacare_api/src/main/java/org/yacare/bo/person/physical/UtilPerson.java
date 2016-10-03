package org.yacare.bo.person.physical;

import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.utiljdbc.ConnectionWrapper;
import org.yacare.model.geo.Address;
import org.yacare.model.person.communication_options.email.Email;
import org.yacare.model.person.communication_options.phone.Phone;
import org.yacare.model.person.physical.Person;

public class UtilPerson {

	public Person completeData(Person person,
			ConnectionWrapper connectionWrapper) {

		// ///////////////////////////////////////////////////////////

		if (person != null) {

			String personId = person.getId();

			// ----------------------------------

			String sql = "SELECT * FROM yacare.f_main_address_person_by_person_id(?);";

			Address mainAddres = (Address) connectionWrapper.findToJsonById(
					sql, Address.class, personId);

			person.getCommunicationOptions().getAddresses()
					.setMainAddress(mainAddres);

			// ----------------------------------

			sql = "SELECT * FROM yacare.f_alternative_addresses_person_by_person_id(?);";

			List<Object> list = connectionWrapper.findToJsonArray(sql,
					Address.class, personId);

			List<Address> alternativeAddresses = new ArrayList<Address>();

			for (Object o : list) {
				alternativeAddresses.add((Address) o);
			}

			person.getCommunicationOptions().getAddresses()
					.setAlternativeAddresses(alternativeAddresses);

			// ----------------------------------

			// sql =
			// "SELECT * FROM yacare.f_main_email_person_by_person_id(?);";
			//
			// Email mainEmail = (Email) connectionWrapper.findToJsonById(sql,
			// Email.class, personId);
			//
			// student.getPersonalInformation().getCommunicationOptions()
			// .getEmails().setMainEmail(mainEmail);

			// ----------------------------------

			sql = "SELECT * FROM yacare.f_alternative_emails_person_by_person_id(?);";

			list = connectionWrapper
					.findToJsonArray(sql, Email.class, personId);

			List<Email> alternativeEmails = new ArrayList<Email>();

			for (Object o : list) {
				alternativeEmails.add((Email) o);
			}

			person.getCommunicationOptions().getEmails()
					.setAlternativeEmails(alternativeEmails);

			// ----------------------------------

			sql = "SELECT * FROM yacare.f_main_phone_person_by_person_id(?);";

			Phone mainPhone = (Phone) connectionWrapper.findToJsonById(sql,
					Phone.class, personId);

			person.getCommunicationOptions().getPhones()
					.setMainPhone(mainPhone);

			// ----------------------------------

			sql = "SELECT * FROM yacare.f_alternative_phones_person_by_person_id(?);";

			list = connectionWrapper
					.findToJsonArray(sql, Phone.class, personId);

			List<Phone> alternativePhones = new ArrayList<Phone>();

			for (Object o : list) {
				alternativePhones.add((Phone) o);
			}

			person.getCommunicationOptions().getPhones()
					.setAlternativePhones(alternativePhones);

		}

		// ///////////////////////////////////////////////////////////

		return person;

	}

}
