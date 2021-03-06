package org.yacare.model.person.identity_document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Documentos de identidad.
 */
@ApiModel(description = "Documentos de identidad.")
public class IdentityDocuments {

	private IdentityDocument mainIdentity = null;
	private List<IdentityDocument> identities = new ArrayList<IdentityDocument>();
	private String summary = null;

	public IdentityDocuments mainIdentity(IdentityDocument mainIdentity) {
		this.mainIdentity = mainIdentity;
		return this;
	}

	/**
	 * Get mainIdentity
	 * 
	 * @return mainIdentity
	 **/
	@ApiModelProperty(value = "")
	public IdentityDocument getMainIdentity() {
		return mainIdentity;
	}

	public void setMainIdentity(IdentityDocument mainIdentity) {
		this.mainIdentity = mainIdentity;
	}

	public IdentityDocuments identities(List<IdentityDocument> identities) {
		this.identities = identities;
		return this;
	}

	public IdentityDocuments addIdentitiesItem(
			IdentityDocument identitiesItem) {
		this.identities.add(identitiesItem);
		return this;
	}

	/**
	 * Get identities
	 * 
	 * @return identities
	 **/
	@ApiModelProperty(value = "")
	public List<IdentityDocument> getIdentities() {
		return identities;
	}

	public void setIdentities(List<IdentityDocument> identities) {
		this.identities = identities;
	}

	public IdentityDocuments summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida de los documentos de identidad.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida de los documentos de identidad.")
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
		IdentityDocuments personIdentityDocuments = (IdentityDocuments) o;
		return Objects.equals(this.mainIdentity,
				personIdentityDocuments.mainIdentity)
				&& Objects.equals(this.identities,
						personIdentityDocuments.identities)
				&& Objects
						.equals(this.summary, personIdentityDocuments.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mainIdentity, identities, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PersonIdentityDocuments {\n");

		sb.append("    mainIdentity: ").append(toIndentedString(mainIdentity))
				.append("\n");
		sb.append("    identities: ").append(toIndentedString(identities))
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
