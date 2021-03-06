package org.yacare.model.academic.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Estado del Estudiante
 */
@ApiModel(description = "Estado del Estudiante")
public class StudentState {

	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;

	public StudentState id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del estado del estudiante.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del estado del estudiante.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StudentState erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el estado del estudiante fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el estado del estudiante fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public StudentState code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código del estado del estudiante.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código del estado del estudiante.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public StudentState name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del estado del estudiante.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del estado del estudiante.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudentState description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción del estado del estudiante.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción del estado del estudiante.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StudentState summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del estado del estudiante.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del estado del estudiante.")
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
		StudentState studentState = (StudentState) o;
		return Objects.equals(this.id, studentState.id)
				&& Objects.equals(this.erased, studentState.erased)
				&& Objects.equals(this.code, studentState.code)
				&& Objects.equals(this.name, studentState.name)
				&& Objects.equals(this.description, studentState.description)
				&& Objects.equals(this.summary, studentState.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class StudentState {\n");

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
