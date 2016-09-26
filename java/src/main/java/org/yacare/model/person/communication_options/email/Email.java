package org.yacare.model.person.communication_options.email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Correo Electrónico
 */
@ApiModel(description = "Correo Electrónico")
public class Email {

	private String id = null;
	private Boolean erased = null;
	private String email = null;
	private String comment = null;

	public Email id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del correo.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del correo.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Email erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el correo fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el correo fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public Email email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Correo electrónico. Por ejemplo dmansilla@unc.edu.ar
	 * 
	 * @return email
	 **/
	@ApiModelProperty(value = "Correo electrónico. Por ejemplo dmansilla@unc.edu.ar")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Email comment(String comment) {
		this.comment = comment;
		return this;
	}

	/**
	 * Comentarios o aclaraciones del correo. Como por ejemplo si es personal,
	 * laboral.
	 * 
	 * @return comment
	 **/
	@ApiModelProperty(value = "Comentarios o aclaraciones del correo. Como por ejemplo si es personal, laboral.")
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
		Email email = (Email) o;
		return Objects.equals(this.id, email.id)
				&& Objects.equals(this.erased, email.erased)
				&& Objects.equals(this.email, email.email)
				&& Objects.equals(this.comment, email.comment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, email, comment);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Email {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
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
