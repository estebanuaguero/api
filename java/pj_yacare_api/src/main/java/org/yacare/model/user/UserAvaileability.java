package org.yacare.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Disponibilid de Usuario del Sistema
 */
@ApiModel(description = "Disponibilid de Usuario del Sistema")
public class UserAvaileability {

	private Boolean checkEmail = null;

	// -----------------------------------------------------
	// --- checkEmail
	// -----------------------------------------------------

	/**
	 * Si el correo electrónico ha sido confirmado.
	 * 
	 * @return checkEmail
	 **/
	@ApiModelProperty(value = "Si el correo electrónico ha sido confirmado.")
	public Boolean getCheckEmail() {
		return checkEmail;
	}

	public void setCheckEmail(Boolean checkEmail) {
		this.checkEmail = checkEmail;
	}

}
