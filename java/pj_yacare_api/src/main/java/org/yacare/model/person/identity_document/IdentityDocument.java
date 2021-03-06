package org.yacare.model.person.identity_document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Documento de Identidad de una Persona. Ver
 * https://es.wikipedia.org/wiki/Documento_de_identidad y
 * https://en.wikipedia.org/wiki/Identity_document
 */
@ApiModel(description = "Documento de Identidad de una Persona. Ver https://es.wikipedia.org/wiki/Documento_de_identidad y https://en.wikipedia.org/wiki/Identity_document")
public class IdentityDocument {
	
	private String identityNumber = null;
	private IdentityType identityType = null;
	private String summary = null;

	public IdentityDocument identityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
		return this;
	}

	/**
	 * Número o código de identificación.
	 * 
	 * @return identityNumber
	 **/
	@ApiModelProperty(value = "Número o código de identificación.")
	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public IdentityDocument identityType(IdentityType identityType) {
		this.identityType = identityType;
		return this;
	}

	/**
	 * Get identityType
	 * 
	 * @return identityType
	 **/
	@ApiModelProperty(value = "")
	public IdentityType getIdentityType() {
		return identityType;
	}

	public void setIdentityType(IdentityType identityType) {
		this.identityType = identityType;
	}

	public IdentityDocument summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida de la nacionalidad de la persona.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida de la nacionalidad de la persona.")
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
		IdentityDocument identityDocument = (IdentityDocument) o;
		return Objects.equals(this.identityNumber,
				identityDocument.identityNumber)
				&& Objects.equals(this.identityType,
						identityDocument.identityType)
				&& Objects.equals(this.summary, identityDocument.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(identityNumber, identityType, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class IdentityDocument {\n");

		sb.append("    identityNumber: ")
				.append(toIndentedString(identityNumber)).append("\n");
		sb.append("    identityType: ").append(toIndentedString(identityType))
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
