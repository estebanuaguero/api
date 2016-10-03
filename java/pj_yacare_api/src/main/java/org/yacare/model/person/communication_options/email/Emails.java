package org.yacare.model.person.communication_options.email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Correos electrónicos.
 */
@ApiModel(description = "Correos electrónicos.")
public class Emails {

	// private Email mainEmail = null;
	private String mainEmail;
	private List<Email> alternativeEmails = new ArrayList<Email>();
	private String summary = null;

	// -----------------------------------------------------
	// --- mainEmail
	// -----------------------------------------------------

	public Emails mainEmail(String mainEmail) {
		this.mainEmail = mainEmail;
		return this;
	}

	/**
	 * Correo electrónico del usuario.
	 * 
	 * @return mainEmail
	 **/
	@ApiModelProperty(value = "Correo electrónico del usuario.")
	public String getMainEmail() {
		return mainEmail;
	}

	public void setMainEmail(String mainEmail) {
		this.mainEmail = mainEmail;
	}

	// public Emails mainEmail(Email mainEmail) {
	// this.mainEmail = mainEmail;
	// return this;
	// }

	// /**
	// * Get mainEmail
	// *
	// * @return mainEmail
	// **/
	// @ApiModelProperty(value = "")
	// public Email getMainEmail() {
	// return mainEmail;
	// }
	//
	// public void setMainEmail(Email mainEmail) {
	// this.mainEmail = mainEmail;
	// }

	// -----------------------------------------------------
	// --- alternativeEmails
	// -----------------------------------------------------

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

	// -----------------------------------------------------
	// --- summary
	// -----------------------------------------------------

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

}
