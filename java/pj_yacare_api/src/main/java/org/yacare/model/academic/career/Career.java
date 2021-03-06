package org.yacare.model.academic.career;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Carrera o Plan de Estudio
 */
@ApiModel(description = "Carrera o Plan de Estudio")
public class Career {
	
	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;
	private Integer yearOfImplementation = null;
	private List<Cycle> cycles = new ArrayList<Cycle>();

	public Career id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único de la carrera.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único de la carrera.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Career erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si la cerrera fue borrada o deshabilitada.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si la cerrera fue borrada o deshabilitada.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public Career code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código de la carrera.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código de la carrera.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Career name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre de la carrera.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre de la carrera.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Career description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción de la carrera.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción de la carrera.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Career summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida de la carrera.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida de la carrera.")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Career yearOfImplementation(Integer yearOfImplementation) {
		this.yearOfImplementation = yearOfImplementation;
		return this;
	}

	/**
	 * Año de implementación de la carrera. Usualmente pude ser llamado por
	 * ejemplo \"Plan 92\", \"Plan de estudio del año 1992\".
	 * 
	 * @return yearOfImplementation
	 **/
	@ApiModelProperty(value = "Año de implementación de la carrera. Usualmente pude ser llamado por ejemplo \"Plan 92\", \"Plan de estudio del año 1992\".")
	public Integer getYearOfImplementation() {
		return yearOfImplementation;
	}

	public void setYearOfImplementation(Integer yearOfImplementation) {
		this.yearOfImplementation = yearOfImplementation;
	}

	public Career cycles(List<Cycle> cycles) {
		this.cycles = cycles;
		return this;
	}

	public Career addCyclesItem(Cycle cyclesItem) {
		this.cycles.add(cyclesItem);
		return this;
	}

	/**
	 * Get cycles
	 * 
	 * @return cycles
	 **/
	@ApiModelProperty(value = "")
	public List<Cycle> getCycles() {
		return cycles;
	}

	public void setCycles(List<Cycle> cycles) {
		this.cycles = cycles;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Career career = (Career) o;
		return Objects.equals(this.id, career.id)
				&& Objects.equals(this.erased, career.erased)
				&& Objects.equals(this.code, career.code)
				&& Objects.equals(this.name, career.name)
				&& Objects.equals(this.description, career.description)
				&& Objects.equals(this.summary, career.summary)
				&& Objects.equals(this.yearOfImplementation,
						career.yearOfImplementation)
				&& Objects.equals(this.cycles, career.cycles);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary,
				yearOfImplementation, cycles);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Career {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description))
				.append("\n");
		sb.append("    summary: ").append(toIndentedString(summary))
				.append("\n");
		sb.append("    yearOfImplementation: ")
				.append(toIndentedString(yearOfImplementation)).append("\n");
		sb.append("    cycles: ").append(toIndentedString(cycles)).append("\n");
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
