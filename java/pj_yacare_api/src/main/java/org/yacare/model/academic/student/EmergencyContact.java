package org.yacare.model.academic.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.yacare.model.person.communication_options.phone.Phone;

/**
 * Contacto de Emergencia de un Estudiante
 */
@ApiModel(description = "Contacto de Emergencia de un Estudiante")
public class EmergencyContact {

	private String id = null;
	private Boolean erased = null;
	private String name = null;
	private String lastName = null;
	private Phone phone = null;
	private String comment = null;

	public EmergencyContact id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del contacto.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del contacto.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EmergencyContact erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el contacto fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el contacto fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public EmergencyContact name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del contacto.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del contacto.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmergencyContact lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Apellido del contacto.
	 * 
	 * @return lastName
	 **/
	@ApiModelProperty(value = "Apellido del contacto.")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EmergencyContact phone(Phone phone) {
		this.phone = phone;
		return this;
	}

	/**
	 * Get phone
	 * 
	 * @return phone
	 **/
	@ApiModelProperty(value = "")
	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public EmergencyContact comment(String comment) {
		this.comment = comment;
		return this;
	}

	/**
	 * Comentarios o aclaraciones del contacto.
	 * 
	 * @return comment
	 **/
	@ApiModelProperty(value = "Comentarios o aclaraciones del contacto.")
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
		EmergencyContact emergencyContact = (EmergencyContact) o;
		return Objects.equals(this.id, emergencyContact.id)
				&& Objects.equals(this.erased, emergencyContact.erased)
				&& Objects.equals(this.name, emergencyContact.name)
				&& Objects.equals(this.lastName, emergencyContact.lastName)
				&& Objects.equals(this.phone, emergencyContact.phone)
				&& Objects.equals(this.comment, emergencyContact.comment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, name, lastName, phone, comment);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EmergencyContact {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName))
				.append("\n");
		sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
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
