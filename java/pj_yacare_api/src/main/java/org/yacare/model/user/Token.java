package org.yacare.model.user;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

public class Token {

	private String id = null;
	private Boolean erased = null;
//	private String tokenValue;
	private Timestamp creationDate;

	// -----------------------------------------------------
	// --- id
	// -----------------------------------------------------

	public Token id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del token.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único de token.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// -----------------------------------------------------
	// --- erased
	// -----------------------------------------------------

	public Token erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el token fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el token fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	// -----------------------------------------------------
	// --- tokenValue
	// -----------------------------------------------------

	public Token tokenValue(String tokenValue) {
		// this.tokenValue = tokenValue;
		return this;
	}

	/**
	 * Token.
	 * 
	 * @return tokenValue
	 **/
	@ApiModelProperty(value = "Token.")
	public String getTokenValue() {
		return id;
	}

	public void setTokenValue(String tokenValue) {
		// this.tokenValue = tokenValue;
	}

	// -----------------------------------------------------
	// --- creationDate
	// -----------------------------------------------------

	public Token creationDate(Timestamp creationDate) {
//		this.creationDate = creationDate;
		return this;
	}

	/**
	 * Fecha y hora en que se creó el token.
	 * 
	 * @return creationDate
	 **/
	@ApiModelProperty(value = "Fecha y hora en que se creó el token.")
	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
//		this.creationDate = creationDate;
	}

}
