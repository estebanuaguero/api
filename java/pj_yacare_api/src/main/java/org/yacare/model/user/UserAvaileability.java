package org.yacare.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Disponibilid de Usuario del Sistema
 */
@ApiModel(description = "Disponibilid de Usuario del Sistema")
public class UserAvaileability {

	private String id = null;
	private String userName;
	private Boolean userCreated = null;
	private Boolean checkEmail = null;

	// -----------------------------------------------------
	// --- id
	// -----------------------------------------------------

	/**
	 * Identificador (UUID) único de usuario.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único de usuario.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// -----------------------------------------------------
	// --- userName
	// -----------------------------------------------------

	public UserAvaileability userName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * Nombre del usuario.
	 * 
	 * @return userName
	 **/
	@ApiModelProperty(value = "Nombre del usuario.")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// -----------------------------------------------------
	// --- userCreated
	// -----------------------------------------------------

	/**
	 * Define si existe un usuario disponible con ese nombre.
	 * 
	 * @return checkEmail
	 **/
	@ApiModelProperty(value = "Define si existe un usuario disponible con ese nombre.")
	public Boolean getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(Boolean userCreated) {
		this.userCreated = userCreated;
	}

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
