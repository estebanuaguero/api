package org.yacare.model.person.nationality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Nacionalidades de la persona.
 */
@ApiModel(description = "Nacionalidades de la persona.")
public class Nationalities {

	private Nationality mainNationality = null;
	private List<Nationality> nationalities = new ArrayList<Nationality>();
	private String summary = null;

	public Nationalities mainNationality(Nationality mainNationality) {
		this.mainNationality = mainNationality;
		return this;
	}

	/**
	 * Get mainNationality
	 * 
	 * @return mainNationality
	 **/
	@ApiModelProperty(value = "")
	public Nationality getMainNationality() {
		return mainNationality;
	}

	public void setMainNationality(Nationality mainNationality) {
		this.mainNationality = mainNationality;
	}

	public Nationalities nationalities(List<Nationality> nationalities) {
		this.nationalities = nationalities;
		return this;
	}

	public Nationalities addNationalitiesItem(
			Nationality nationalitiesItem) {
		this.nationalities.add(nationalitiesItem);
		return this;
	}

	/**
	 * Get nationalities
	 * 
	 * @return nationalities
	 **/
	@ApiModelProperty(value = "")
	public List<Nationality> getNationalities() {
		return nationalities;
	}

	public void setNationalities(List<Nationality> nationalities) {
		this.nationalities = nationalities;
	}

	public Nationalities summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida de las nacionalidades de la persona.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida de las nacionalidades de la persona.")
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
		Nationalities personNationalities = (Nationalities) o;
		return Objects.equals(this.mainNationality,
				personNationalities.mainNationality)
				&& Objects.equals(this.nationalities,
						personNationalities.nationalities)
				&& Objects.equals(this.summary, personNationalities.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mainNationality, nationalities, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PersonNationalities {\n");

		sb.append("    mainNationality: ")
				.append(toIndentedString(mainNationality)).append("\n");
		sb.append("    nationalities: ")
				.append(toIndentedString(nationalities)).append("\n");
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
