package org.yacare.model.academic.student.legal_guardian;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Nivel de Formación Educativa de una Persona
 */
@ApiModel(description = "Nivel de Formación Educativa de una Persona")
public class EducationLevel {

	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;

	public EducationLevel id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del nivel de formación educativa.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del nivel de formación educativa.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EducationLevel erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el nivel de formación educativa fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el nivel de formación educativa fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public EducationLevel code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código del nivel de formación educativa.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código del nivel de formación educativa.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public EducationLevel name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del nivel de formación educativa.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del nivel de formación educativa.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EducationLevel description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción del nivel de formación educativa.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción del nivel de formación educativa.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EducationLevel summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del nivel de formación educativa.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del nivel de formación educativa.")
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
		EducationLevel educationLevel = (EducationLevel) o;
		return Objects.equals(this.id, educationLevel.id)
				&& Objects.equals(this.erased, educationLevel.erased)
				&& Objects.equals(this.code, educationLevel.code)
				&& Objects.equals(this.name, educationLevel.name)
				&& Objects.equals(this.description, educationLevel.description)
				&& Objects.equals(this.summary, educationLevel.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EducationLevel {\n");

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
