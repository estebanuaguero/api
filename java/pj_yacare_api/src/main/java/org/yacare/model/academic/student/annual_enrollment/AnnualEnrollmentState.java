package org.yacare.model.academic.student.annual_enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Estado de la Matrícula Escolar Anual
 */
@ApiModel(description = "Estado de la Matrícula Escolar Anual")
public class AnnualEnrollmentState {

	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;

	public AnnualEnrollmentState id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del estado de la matrícula.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del estado de la matrícula.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AnnualEnrollmentState erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el estado de la matrícula fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el estado de la matrícula fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public AnnualEnrollmentState code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código del estado de la matrícula.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código del estado de la matrícula.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AnnualEnrollmentState name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del estado de la matrícula.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del estado de la matrícula.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AnnualEnrollmentState description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción del estado de la matrícula.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción del estado de la matrícula.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AnnualEnrollmentState summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del estado de la matrícula.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del estado de la matrícula.")
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
		AnnualEnrollmentState annualEnrollmentState = (AnnualEnrollmentState) o;
		return Objects.equals(this.id, annualEnrollmentState.id)
				&& Objects.equals(this.erased, annualEnrollmentState.erased)
				&& Objects.equals(this.code, annualEnrollmentState.code)
				&& Objects.equals(this.name, annualEnrollmentState.name)
				&& Objects.equals(this.description,
						annualEnrollmentState.description)
				&& Objects.equals(this.summary, annualEnrollmentState.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AnnualEnrollmentState {\n");

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
