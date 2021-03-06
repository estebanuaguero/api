package org.yacare.model.geo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Ubicación Geográfica
 */
@ApiModel(description = "Ubicación Geográfica")
public class GeoLocation {

	private Country country = null;
	private AdminAreaLevel1 adminAreaLevel1 = null;
	private AdminAreaLevel2 adminAreaLevel2 = null;
	private String locality = null;
	private String zipCode = null;
	private GeoCoordinates geoCoordinates = null;
	private String comment = null;
	private String summary = null;

	public GeoLocation country(Country country) {
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

	public GeoLocation adminAreaLevel1(AdminAreaLevel1 adminAreaLevel1) {
		this.adminAreaLevel1 = adminAreaLevel1;
		return this;
	}

	/**
	 * Get adminAreaLevel1
	 * 
	 * @return adminAreaLevel1
	 **/
	@ApiModelProperty(value = "")
	public AdminAreaLevel1 getAdminAreaLevel1() {
		return adminAreaLevel1;
	}

	public void setAdminAreaLevel1(AdminAreaLevel1 adminAreaLevel1) {
		this.adminAreaLevel1 = adminAreaLevel1;
	}

	public GeoLocation adminAreaLevel2(AdminAreaLevel2 adminAreaLevel2) {
		this.adminAreaLevel2 = adminAreaLevel2;
		return this;
	}

	/**
	 * Get adminAreaLevel2
	 * 
	 * @return adminAreaLevel2
	 **/
	@ApiModelProperty(value = "")
	public AdminAreaLevel2 getAdminAreaLevel2() {
		return adminAreaLevel2;
	}

	public void setAdminAreaLevel2(AdminAreaLevel2 adminAreaLevel2) {
		this.adminAreaLevel2 = adminAreaLevel2;
	}

	public GeoLocation locality(String locality) {
		this.locality = locality;
		return this;
	}

	/**
	 * Localidad, por ejemplo Ciudad, pueblo, etc. Ver
	 * https://es.wikipedia.org/wiki/Localidad
	 * 
	 * @return locality
	 **/
	@ApiModelProperty(value = "Localidad, por ejemplo Ciudad, pueblo, etc. Ver https://es.wikipedia.org/wiki/Localidad")
	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public GeoLocation zipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}

	/**
	 * Código postal, por ejemplo 5000, 5006, etc. Ver
	 * https://es.wikipedia.org/wiki/C%C3%B3digo_postal
	 * 
	 * @return zipCode
	 **/
	@ApiModelProperty(value = "Código postal, por ejemplo 5000, 5006, etc. Ver https://es.wikipedia.org/wiki/C%C3%B3digo_postal")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public GeoLocation geoCoordinates(GeoCoordinates geoCoordinates) {
		this.geoCoordinates = geoCoordinates;
		return this;
	}

	/**
	 * Get geoCoordinates
	 * 
	 * @return geoCoordinates
	 **/
	@ApiModelProperty(value = "")
	public GeoCoordinates getGeoCoordinates() {
		return geoCoordinates;
	}

	public void setGeoCoordinates(GeoCoordinates geoCoordinates) {
		this.geoCoordinates = geoCoordinates;
	}

	public GeoLocation comment(String comment) {
		this.comment = comment;
		return this;
	}

	/**
	 * Algún dato extra de la ubicación.
	 * 
	 * @return comment
	 **/
	@ApiModelProperty(value = "Algún dato extra de la ubicación.")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public GeoLocation summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida de la ubicación geográfica.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida de la ubicación geográfica.")
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
		GeoLocation geoLocation = (GeoLocation) o;
		return Objects.equals(this.country, geoLocation.country)
				&& Objects.equals(this.adminAreaLevel1,
						geoLocation.adminAreaLevel1)
				&& Objects.equals(this.adminAreaLevel2,
						geoLocation.adminAreaLevel2)
				&& Objects.equals(this.locality, geoLocation.locality)
				&& Objects.equals(this.zipCode, geoLocation.zipCode)
				&& Objects.equals(this.geoCoordinates,
						geoLocation.geoCoordinates)
				&& Objects.equals(this.comment, geoLocation.comment)
				&& Objects.equals(this.summary, geoLocation.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, adminAreaLevel1, adminAreaLevel2,
				locality, zipCode, geoCoordinates, comment, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GeoLocation {\n");

		sb.append("    country: ").append(toIndentedString(country))
				.append("\n");
		sb.append("    adminAreaLevel1: ")
				.append(toIndentedString(adminAreaLevel1)).append("\n");
		sb.append("    adminAreaLevel2: ")
				.append(toIndentedString(adminAreaLevel2)).append("\n");
		sb.append("    locality: ").append(toIndentedString(locality))
				.append("\n");
		sb.append("    zipCode: ").append(toIndentedString(zipCode))
				.append("\n");
		sb.append("    geoCoordinates: ")
				.append(toIndentedString(geoCoordinates)).append("\n");
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
