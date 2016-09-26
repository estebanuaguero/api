package org.yacare.model.academic.career;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Periodo de Carrera
 */
@ApiModel(description = "Periodo de Carrera")
public class Period {
	
	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;
	private Integer number = null;

	public Period id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del periodo de la carrera.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del periodo de la carrera.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Period erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el periodo de la cerrera fue borrada o deshabilitada.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el periodo de la cerrera fue borrada o deshabilitada.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public Period code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código del periodo de la carrera.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código del periodo de la carrera.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Period name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del periodo de la carrera.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del periodo de la carrera.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Period description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción del periodo de la carrera.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción del periodo de la carrera.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Period summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del periodo de la carrera.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del periodo de la carrera.")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Period number(Integer number) {
		this.number = number;
		return this;
	}

	/**
	 * Orden o número del periodo de la carrera.
	 * 
	 * @return number
	 **/
	@ApiModelProperty(value = "Orden o número del periodo de la carrera.")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Period period = (Period) o;
		return Objects.equals(this.id, period.id)
				&& Objects.equals(this.erased, period.erased)
				&& Objects.equals(this.code, period.code)
				&& Objects.equals(this.name, period.name)
				&& Objects.equals(this.description, period.description)
				&& Objects.equals(this.summary, period.summary)
				&& Objects.equals(this.number, period.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary,
				number);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Period {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description))
				.append("\n");
		sb.append("    summary: ").append(toIndentedString(summary))
				.append("\n");
		sb.append("    number: ").append(toIndentedString(number)).append("\n");
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
