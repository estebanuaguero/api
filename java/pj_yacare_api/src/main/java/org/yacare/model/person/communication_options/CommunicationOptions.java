package org.yacare.model.person.communication_options;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.yacare.model.person.communication_options.address.Addresses;
import org.yacare.model.person.communication_options.email.Emails;
import org.yacare.model.person.communication_options.phone.Phones;

/**
 * Opciones para comunicarse, como domicilio, teléfonos, correos
 * electrónicos, etc.
 */
@ApiModel(description = "Opciones para comunicarse, como domicilio, teléfonos, correos electrónicos, etc.")
public class CommunicationOptions {
	
	private Addresses addresses = new Addresses();
	private Emails emails = new Emails();
	private Phones phones = new Phones();
	private String comment = null;

	public CommunicationOptions addresses(Addresses addresses) {
		this.addresses = addresses;
		return this;
	}

	/**
	 * Get addresses
	 * 
	 * @return addresses
	 **/
	@ApiModelProperty(value = "")
	public Addresses getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}

	public CommunicationOptions emails(Emails emails) {
		this.emails = emails;
		return this;
	}

	/**
	 * Get emails
	 * 
	 * @return emails
	 **/
	@ApiModelProperty(value = "")
	public Emails getEmails() {
		return emails;
	}

	public void setEmails(Emails emails) {
		this.emails = emails;
	}

	public CommunicationOptions phones(Phones phones) {
		this.phones = phones;
		return this;
	}

	/**
	 * Get phones
	 * 
	 * @return phones
	 **/
	@ApiModelProperty(value = "")
	public Phones getPhones() {
		return phones;
	}

	public void setPhones(Phones phones) {
		this.phones = phones;
	}

	public CommunicationOptions comment(String comment) {
		this.comment = comment;
		return this;
	}

	/**
	 * Comentarios, aclaraciones u otros medios de contacto.
	 * 
	 * @return comment
	 **/
	@ApiModelProperty(value = "Comentarios, aclaraciones u otros medios de contacto.")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CommunicationOptions personCommunicationOptions = (CommunicationOptions) o;
		return Objects.equals(this.addresses,
				personCommunicationOptions.addresses)
				&& Objects.equals(this.emails,
						personCommunicationOptions.emails)
				&& Objects.equals(this.phones,
						personCommunicationOptions.phones)
				&& Objects.equals(this.comment,
						personCommunicationOptions.comment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(addresses, emails, phones, comment);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PersonCommunicationOptions {\n");

		sb.append("    addresses: ").append(toIndentedString(addresses))
				.append("\n");
		sb.append("    emails: ").append(toIndentedString(emails)).append("\n");
		sb.append("    phones: ").append(toIndentedString(phones)).append("\n");
		sb.append("    comment: ").append(toIndentedString(comment))
				.append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
