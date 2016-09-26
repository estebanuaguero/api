package org.yacare.model.health;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Grupo Sanguíneo de una Persona. Ver
 * https://es.wikipedia.org/wiki/Grupo_sangu%C3%ADneo
 */
@ApiModel(description = "Grupo Sanguíneo de una Persona. Ver https://es.wikipedia.org/wiki/Grupo_sangu%C3%ADneo")
public class BloodGroup {
	
	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;

	public BloodGroup id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del grupo sanguíneo.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del grupo sanguíneo.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BloodGroup erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el grupo sanguíneo fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el grupo sanguíneo fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public BloodGroup code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código del grupo sanguíneo.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código del grupo sanguíneo.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BloodGroup name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del grupo sanguíneo.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del grupo sanguíneo.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BloodGroup description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción del grupo sanguíneo.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción del grupo sanguíneo.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BloodGroup summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del grupo sanguíneo.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del grupo sanguíneo.")
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
		BloodGroup bloodGroup = (BloodGroup) o;
		return Objects.equals(this.id, bloodGroup.id)
				&& Objects.equals(this.erased, bloodGroup.erased)
				&& Objects.equals(this.code, bloodGroup.code)
				&& Objects.equals(this.name, bloodGroup.name)
				&& Objects.equals(this.description, bloodGroup.description)
				&& Objects.equals(this.summary, bloodGroup.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BloodGroup {\n");

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
