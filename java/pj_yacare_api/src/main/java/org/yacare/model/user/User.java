package org.yacare.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.yacare.model.person.physical.Person;

/**
 * Usuario del Sistema
 */
@ApiModel(description = "Usuario del Sistema")
public class User {

	private String id = null;
	private Boolean erased = null;
	private Person personalInformation = null;
	private String userName;
	private String password;
	private String mainEmail;

	// -----------------------------------------------------
	// --- id
	// -----------------------------------------------------

	public User id(String id) {
		this.id = id;
		return this;
	}

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
	// --- erased
	// -----------------------------------------------------

	public User erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el usuario fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el usuario fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	// -----------------------------------------------------
	// --- personalInformation
	// -----------------------------------------------------

	public User personalInformation(Person personalInformation) {
		this.personalInformation = personalInformation;
		return this;
	}

	/**
	 * Get personalInformation
	 * 
	 * @return personalInformation
	 **/
	@ApiModelProperty(value = "")
	public Person getPersonalInformation() {
		return personalInformation;
	}

	public void setPersonalInformation(Person personalInformation) {
		this.personalInformation = personalInformation;
	}

	// -----------------------------------------------------
	// --- userName
	// -----------------------------------------------------

	public User userName(String userName) {
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
	// --- password
	// -----------------------------------------------------

	public User password(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Contraseña del usuario.
	 * 
	 * @return password
	 **/
	@ApiModelProperty(value = "Contraseña del usuario.")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// -----------------------------------------------------
	// --- mainEmail
	// -----------------------------------------------------

	public User mainEmail(String mainEmail) {
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

}
