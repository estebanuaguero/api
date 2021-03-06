package org.yacare.model.health;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Factor Sanguíneo de una Persona. Ver
 * https://es.wikipedia.org/wiki/Grupo_sangu%C3%ADneo
 */
@ApiModel(description = "Factor Sanguíneo de una Persona. Ver https://es.wikipedia.org/wiki/Grupo_sangu%C3%ADneo")
public class BloodFactor {

	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;

	public BloodFactor id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del factor Sanguíneo.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del factor Sanguíneo.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BloodFactor erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el factor Sanguíneo fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el factor Sanguíneo fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public BloodFactor code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código del factor Sanguíneo.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código del factor Sanguíneo.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BloodFactor name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del factor Sanguíneo.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del factor Sanguíneo.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BloodFactor description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción del factor Sanguíneo.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción del factor Sanguíneo.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BloodFactor summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del factor Sanguíneo.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del factor Sanguíneo.")
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
		BloodFactor bloodFactor = (BloodFactor) o;
		return Objects.equals(this.id, bloodFactor.id)
				&& Objects.equals(this.erased, bloodFactor.erased)
				&& Objects.equals(this.code, bloodFactor.code)
				&& Objects.equals(this.name, bloodFactor.name)
				&& Objects.equals(this.description, bloodFactor.description)
				&& Objects.equals(this.summary, bloodFactor.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BloodFactor {\n");

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
