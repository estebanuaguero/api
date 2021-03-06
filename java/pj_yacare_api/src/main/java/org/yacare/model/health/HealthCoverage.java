package org.yacare.model.health;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Cobertura Médica de una Persona, también llamada por ejemplo Obra Social, o
 * Prepaga.
 */
@ApiModel(description = "Cobertura Médica de una Persona, también llamada por ejemplo Obra Social, o Prepaga.")
public class HealthCoverage {
	
	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;

	public HealthCoverage id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único de la cobertura.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único de la cobertura.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HealthCoverage erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si la cobertura fue borrada o deshabilitada.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si la cobertura fue borrada o deshabilitada.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public HealthCoverage code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código de la cobertura.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código de la cobertura.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public HealthCoverage name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre de la cobertura.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre de la cobertura.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HealthCoverage description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción de la cobertura.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción de la cobertura.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HealthCoverage summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida de la cobertura.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida de la cobertura.")
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
		HealthCoverage healthCoverage = (HealthCoverage) o;
		return Objects.equals(this.id, healthCoverage.id)
				&& Objects.equals(this.erased, healthCoverage.erased)
				&& Objects.equals(this.code, healthCoverage.code)
				&& Objects.equals(this.name, healthCoverage.name)
				&& Objects.equals(this.description, healthCoverage.description)
				&& Objects.equals(this.summary, healthCoverage.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class HealthCoverage {\n");

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
