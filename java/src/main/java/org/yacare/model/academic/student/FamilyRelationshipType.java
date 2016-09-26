package org.yacare.model.academic.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Tipo de Relación Familiar de una Persona
 */
@ApiModel(description = "Tipo de Relación Familiar de una Persona")
public class FamilyRelationshipType {

	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;

	public FamilyRelationshipType id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del tipo de relación.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del tipo de relación.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FamilyRelationshipType erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el tipo de relación fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el tipo de relación fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public FamilyRelationshipType code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código del tipo de relación.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código del tipo de relación.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public FamilyRelationshipType name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del tipo de relación.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del tipo de relación.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FamilyRelationshipType description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción del tipo de relación.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción del tipo de relación.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FamilyRelationshipType summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del tipo de relación.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del tipo de relación.")
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
		FamilyRelationshipType familyRelationshipType = (FamilyRelationshipType) o;
		return Objects.equals(this.id, familyRelationshipType.id)
				&& Objects.equals(this.erased, familyRelationshipType.erased)
				&& Objects.equals(this.code, familyRelationshipType.code)
				&& Objects.equals(this.name, familyRelationshipType.name)
				&& Objects.equals(this.description,
						familyRelationshipType.description)
				&& Objects.equals(this.summary, familyRelationshipType.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FamilyRelationshipType {\n");

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
