package org.yacare.model.person.physical;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.util.Objects;

import org.yacare.model.geo.GeoLocation;

/**
 * Datos referentes al nacimiento de la persona.
 */
@ApiModel(description = "Datos referentes al nacimiento de la persona.")
public class PersonBirth {

	private String id = null;
	private Date dateOfBirth = null;
	private Integer age = null;
	private String fullAge = null;
	private GeoLocation placeOfBirth = null;
	private String summary = null;

	public PersonBirth id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único de la persona (Datos de nacimiento).
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único de la persona (Datos de nacimiento).")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// public PersonBirth dateOfBirth(DateTime dateOfBirth) {
	// this.dateOfBirth = dateOfBirth;
	// return this;
	// }

	public PersonBirth dateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	/**
	 * Fecha de nacimiento de la persona. Definido en base a RFC3339, ver
	 * https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14
	 * 
	 * @return dateOfBirth
	 **/
	@ApiModelProperty(value = "Fecha de nacimiento de la persona. Definido en base a RFC3339, ver https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	// public DateTime getDateOfBirth() {
	// return dateOfBirth;
	// }

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	// public void setDateOfBirth(DateTime dateOfBirth) {
	// this.dateOfBirth = dateOfBirth;
	// }

	public PersonBirth age(Integer age) {
		this.age = age;
		return this;
	}

	/**
	 * Edad de la persona, definida solo en años, por ejemplo 32 años.
	 * 
	 * @return age
	 **/
	@ApiModelProperty(value = "Edad de la persona, definida solo en años, por ejemplo 32 años.")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public PersonBirth fullAge(String fullAge) {
		this.fullAge = fullAge;
		return this;
	}

	/**
	 * Edad de la persona, definida en años, meses y días, por ejemplo 14 años,
	 * 1 mes y 16 días.
	 * 
	 * @return fullAge
	 **/
	@ApiModelProperty(value = "Edad de la persona, definida en años, meses y días, por ejemplo 14 años, 1 mes y 16 días.")
	public String getFullAge() {
		return fullAge;
	}

	public void setFullAge(String fullAge) {
		this.fullAge = fullAge;
	}

	public PersonBirth placeOfBirth(GeoLocation placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
		return this;
	}

	/**
	 * Get placeOfBirth
	 * 
	 * @return placeOfBirth
	 **/
	@ApiModelProperty(value = "")
	public GeoLocation getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(GeoLocation placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public PersonBirth summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida de los datos de nacimiento.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida de los datos de nacimiento.")
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
		PersonBirth personBirth = (PersonBirth) o;
		return Objects.equals(this.dateOfBirth, personBirth.dateOfBirth)
				&& Objects.equals(this.age, personBirth.age)
				&& Objects.equals(this.fullAge, personBirth.fullAge)
				&& Objects.equals(this.placeOfBirth, personBirth.placeOfBirth)
				&& Objects.equals(this.summary, personBirth.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, age, fullAge, placeOfBirth, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PersonBirth {\n");

		sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth))
				.append("\n");
		sb.append("    age: ").append(toIndentedString(age)).append("\n");
		sb.append("    fullAge: ").append(toIndentedString(fullAge))
				.append("\n");
		sb.append("    placeOfBirth: ").append(toIndentedString(placeOfBirth))
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
