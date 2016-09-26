package org.yacare.model.person.communication_options.email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Correos electrónicos.
 */
@ApiModel(description = "Correos electrónicos.")
public class Emails {
	
	private Email mainEmail = null;
	private List<Email> alternativeEmails = new ArrayList<Email>();
	private String summary = null;

	public Emails mainEmail(Email mainEmail) {
		this.mainEmail = mainEmail;
		return this;
	}

	/**
	 * Get mainEmail
	 * 
	 * @return mainEmail
	 **/
	@ApiModelProperty(value = "")
	public Email getMainEmail() {
		return mainEmail;
	}

	public void setMainEmail(Email mainEmail) {
		this.mainEmail = mainEmail;
	}

	public Emails alternativeEmails(List<Email> alternativeEmails) {
		this.alternativeEmails = alternativeEmails;
		return this;
	}

	public Emails addAlternativeEmailsItem(Email alternativeEmailsItem) {
		this.alternativeEmails.add(alternativeEmailsItem);
		return this;
	}

	/**
	 * Get alternativeEmails
	 * 
	 * @return alternativeEmails
	 **/
	@ApiModelProperty(value = "")
	public List<Email> getAlternativeEmails() {
		return alternativeEmails;
	}

	public void setAlternativeEmails(List<Email> alternativeEmails) {
		this.alternativeEmails = alternativeEmails;
	}

	public Emails summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida de los correos electrónicos.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida de los correos electrónicos.")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Emails personCommunicationOptionsEmails = (Emails) o;
		return Objects.equals(this.mainEmail,
				personCommunicationOptionsEmails.mainEmail)
				&& Objects.equals(this.alternativeEmails,
						personCommunicationOptionsEmails.alternativeEmails)
				&& Objects.equals(this.summary,
						personCommunicationOptionsEmails.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mainEmail, alternativeEmails, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PersonCommunicationOptionsEmails {\n");

		sb.append("    mainEmail: ").append(toIndentedString(mainEmail))
				.append("\n");
		sb.append("    alternativeEmails: ")
				.append(toIndentedString(alternativeEmails)).append("\n");
		sb.append("    summary: ").append(toIndentedString(summary))
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
