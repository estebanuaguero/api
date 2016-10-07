package org.yacare.model.user;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

public class Token {

	private String id = null;
	private Timestamp creationDate;
	private Boolean used = null;

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
	// --- creationDate
	// -----------------------------------------------------

	public Token creationDate(Timestamp creationDate) {
		// this.creationDate = creationDate;
		return this;
	}

	/**
	 * Fecha y hora en que se creó el token.
	 * 
	 * @return creationDate
	 **/
	@ApiModelProperty(value = "Fecha y hora en que se creó el token.")
	public Timestamp getCreationDate() {
		// return new DateTime(System.currentTimeMillis());
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	// -----------------------------------------------------
	// --- used
	// -----------------------------------------------------

	/**
	 * Determina si el token fue usado.
	 * 
	 * @return used
	 **/
	@ApiModelProperty(value = "Determina si el token fue usado.")
	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

}
