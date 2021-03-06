package org.yacare.model.academic.career;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Ciclo de Carrera o Ciclo de Plan de Estudio
 */
@ApiModel(description = "Ciclo de Carrera o Ciclo de Plan de Estudio")
public class Cycle {

	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;
	private Integer number = null;
	private List<Period> periods = new ArrayList<Period>();

	public Cycle id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del ciclo de la carrera.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del ciclo de la carrera.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Cycle erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el ciclo de la cerrera fue borrada o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el ciclo de la cerrera fue borrada o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public Cycle code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código del ciclo de la carrera.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código del ciclo de la carrera.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Cycle name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del ciclo de la carrera.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del ciclo de la carrera.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cycle description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción del ciclo de la carrera.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción del ciclo de la carrera.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Cycle summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del cilco de la carrera.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del cilco de la carrera.")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Cycle number(Integer number) {
		this.number = number;
		return this;
	}

	/**
	 * Orden o número del ciclo de la carrera.
	 * 
	 * @return number
	 **/
	@ApiModelProperty(value = "Orden o número del ciclo de la carrera.")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Cycle periods(List<Period> periods) {
		this.periods = periods;
		return this;
	}

	public Cycle addPeriodsItem(Period periodsItem) {
		this.periods.add(periodsItem);
		return this;
	}

	/**
	 * Get periods
	 * 
	 * @return periods
	 **/
	@ApiModelProperty(value = "")
	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Cycle cycle = (Cycle) o;
		return Objects.equals(this.id, cycle.id)
				&& Objects.equals(this.erased, cycle.erased)
				&& Objects.equals(this.code, cycle.code)
				&& Objects.equals(this.name, cycle.name)
				&& Objects.equals(this.description, cycle.description)
				&& Objects.equals(this.summary, cycle.summary)
				&& Objects.equals(this.number, cycle.number)
				&& Objects.equals(this.periods, cycle.periods);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary,
				number, periods);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Cycle {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description))
				.append("\n");
		sb.append("    summary: ").append(toIndentedString(summary))
				.append("\n");
		sb.append("    number: ").append(toIndentedString(number)).append("\n");
		sb.append("    periods: ").append(toIndentedString(periods))
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
