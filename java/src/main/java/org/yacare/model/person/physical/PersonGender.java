package org.yacare.model.person.physical;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Género de la Persona
 */
@ApiModel(description = "Género de la Persona")
public class PersonGender {

	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;

	public PersonGender id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del género de la persona.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del género de la persona.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PersonGender erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el género de la persona fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el género de la persona fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public PersonGender code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código del género de la persona. Por ejemplo M | F
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código del género de la persona. Por ejemplo M | F")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public PersonGender name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del género de la persona. Por ejemplo Masculíno | Femenino
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del género de la persona. Por ejemplo Masculíno | Femenino")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonGender description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción del género de la persona. Por ejemplo Hombre | Mujer
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción del género de la persona. Por ejemplo Hombre | Mujer")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PersonGender summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del género de la persona.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del género de la persona.")
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
		PersonGender gender = (PersonGender) o;
		return Objects.equals(this.id, gender.id)
				&& Objects.equals(this.erased, gender.erased)
				&& Objects.equals(this.code, gender.code)
				&& Objects.equals(this.name, gender.name)
				&& Objects.equals(this.description, gender.description)
				&& Objects.equals(this.summary, gender.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Gender {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description))
				.append("\n");
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
