package org.yacare.model.person.identity_document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.yacare.model.geo.Country;

/**
 * Tipo de Documento de Identidad de una Persona. Ver
 * https://es.wikipedia.org/wiki/Documento_de_identidad y
 * https://en.wikipedia.org/wiki/Identity_document
 */
@ApiModel(description = "Tipo de Documento de Identidad de una Persona. Ver https://es.wikipedia.org/wiki/Documento_de_identidad y https://en.wikipedia.org/wiki/Identity_document")
public class IdentityType {

	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;
	private Country issuingCountry = null;

	public IdentityType id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del tipo de documento.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del tipo de documento.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IdentityType erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el tipo de documento fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el tipo de documento fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public IdentityType code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código del tipo de documento.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código del tipo de documento.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public IdentityType name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del tipo de documento.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del tipo de documento.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IdentityType description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción del tipo de documento.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción del tipo de documento.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IdentityType summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del tipo de documento.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del tipo de documento.")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public IdentityType issuingCountry(Country issuingCountry) {
		this.issuingCountry = issuingCountry;
		return this;
	}

	/**
	 * Get issuingCountry
	 * 
	 * @return issuingCountry
	 **/
	@ApiModelProperty(value = "")
	public Country getIssuingCountry() {
		return issuingCountry;
	}

	public void setIssuingCountry(Country issuingCountry) {
		this.issuingCountry = issuingCountry;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		IdentityType identityType = (IdentityType) o;
		return Objects.equals(this.id, identityType.id)
				&& Objects.equals(this.erased, identityType.erased)
				&& Objects.equals(this.code, identityType.code)
				&& Objects.equals(this.name, identityType.name)
				&& Objects.equals(this.description, identityType.description)
				&& Objects.equals(this.summary, identityType.summary)
				&& Objects.equals(this.issuingCountry,
						identityType.issuingCountry);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary,
				issuingCountry);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class IdentityType {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description))
				.append("\n");
		sb.append("    summary: ").append(toIndentedString(summary))
				.append("\n");
		sb.append("    issuingCountry: ")
				.append(toIndentedString(issuingCountry)).append("\n");
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
