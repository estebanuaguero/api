package org.yacare.model.person.nationality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.yacare.model.geo.Country;

/**
 * Nacionalidad de una Persona
 */
@ApiModel(description = "Nacionalidad de una Persona")
public class Nationality {

	private Country country = null;
	private String comment = null;
	private String summary = null;

	public Nationality country(Country country) {
		this.country = country;
		return this;
	}

	/**
	 * Get country
	 * 
	 * @return country
	 **/
	@ApiModelProperty(value = "")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Nationality comment(String comment) {
		this.comment = comment;
		return this;
	}

	/**
	 * Descripción de la nacionalidad de la persona.
	 * 
	 * @return comment
	 **/
	@ApiModelProperty(value = "Descripción de la nacionalidad de la persona.")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Nationality summary(String summary) {
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
		Nationality nationality = (Nationality) o;
		return Objects.equals(this.country, nationality.country)
				&& Objects.equals(this.comment, nationality.comment)
				&& Objects.equals(this.summary, nationality.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, comment, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Nationality {\n");

		sb.append("    country: ").append(toIndentedString(country))
				.append("\n");
		sb.append("    comment: ").append(toIndentedString(comment))
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
