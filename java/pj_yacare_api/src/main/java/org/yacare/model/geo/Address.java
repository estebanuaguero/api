package org.yacare.model.geo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Domicilio
 */
@ApiModel(description = "Domicilio")
public class Address {

	private String id = null;
	private Boolean erased = null;
	private Country country = null;
	private AdminAreaLevel1 adminAreaLevel1 = null;
	private AdminAreaLevel2 adminAreaLevel2 = null;
	private String locality = null;
	private String zipCode = null;
	private String neightbourhood = null;
	private String street = null;
	private String streetNumber = null;
	private String floor = null;
	private String room = null;
	private String building = null;
	private GeoCoordinates geoCoordinates = null;
	private String comment = null;
	private String summary = null;

	public Address id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del domicilio.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del domicilio.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el domicilio fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el domicilio fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public Address country(Country country) {
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

	public Address adminAreaLevel1(AdminAreaLevel1 adminAreaLevel1) {
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

	public Address adminAreaLevel2(AdminAreaLevel2 adminAreaLevel2) {
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

	public Address locality(String locality) {
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

	public Address zipCode(String zipCode) {
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

	public Address neightbourhood(String neightbourhood) {
		this.neightbourhood = neightbourhood;
		return this;
	}

	/**
	 * Vecindario o también llamado distrito, barrio.
	 * 
	 * @return neightbourhood
	 **/
	@ApiModelProperty(value = "Vecindario o también llamado distrito, barrio.")
	public String getNeightbourhood() {
		return neightbourhood;
	}

	public void setNeightbourhood(String neightbourhood) {
		this.neightbourhood = neightbourhood;
	}

	public Address street(String street) {
		this.street = street;
		return this;
	}

	/**
	 * Nombre de calle.
	 * 
	 * @return street
	 **/
	@ApiModelProperty(value = "Nombre de calle.")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Address streetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
		return this;
	}

	/**
	 * Número de calle, también llamado número de puerta o número de casa.
	 * 
	 * @return streetNumber
	 **/
	@ApiModelProperty(value = "Número de calle, también llamado número de puerta o número de casa.")
	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public Address floor(String floor) {
		this.floor = floor;
		return this;
	}

	/**
	 * Número de piso o piso.
	 * 
	 * @return floor
	 **/
	@ApiModelProperty(value = "Número de piso o piso.")
	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Address room(String room) {
		this.room = room;
		return this;
	}

	/**
	 * Número de departamento, o número de puerta, o también llamado PH.
	 * 
	 * @return room
	 **/
	@ApiModelProperty(value = "Número de departamento, o número de puerta, o también llamado PH.")
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Address building(String building) {
		this.building = building;
		return this;
	}

	/**
	 * Nombre del edificio o torre. Por ejemplo Torre Ángela.
	 * 
	 * @return building
	 **/
	@ApiModelProperty(value = "Nombre del edificio o torre. Por ejemplo Torre Ángela.")
	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public Address geoCoordinates(GeoCoordinates geoCoordinates) {
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

	public Address comment(String comment) {
		this.comment = comment;
		return this;
	}

	/**
	 * Algún dato extra del domicilio.
	 * 
	 * @return comment
	 **/
	@ApiModelProperty(value = "Algún dato extra del domicilio.")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Address summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del domicilio.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del domicilio.")
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
		Address address = (Address) o;
		return Objects.equals(this.id, address.id)
				&& Objects.equals(this.erased, address.erased)
				&& Objects.equals(this.country, address.country)
				&& Objects
						.equals(this.adminAreaLevel1, address.adminAreaLevel1)
				&& Objects
						.equals(this.adminAreaLevel2, address.adminAreaLevel2)
				&& Objects.equals(this.locality, address.locality)
				&& Objects.equals(this.zipCode, address.zipCode)
				&& Objects.equals(this.neightbourhood, address.neightbourhood)
				&& Objects.equals(this.street, address.street)
				&& Objects.equals(this.streetNumber, address.streetNumber)
				&& Objects.equals(this.floor, address.floor)
				&& Objects.equals(this.room, address.room)
				&& Objects.equals(this.building, address.building)
				&& Objects.equals(this.geoCoordinates, address.geoCoordinates)
				&& Objects.equals(this.comment, address.comment)
				&& Objects.equals(this.summary, address.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, country, adminAreaLevel1,
				adminAreaLevel2, locality, zipCode, neightbourhood, street,
				streetNumber, floor, room, building, geoCoordinates, comment,
				summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Address {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
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
		sb.append("    neightbourhood: ")
				.append(toIndentedString(neightbourhood)).append("\n");
		sb.append("    street: ").append(toIndentedString(street)).append("\n");
		sb.append("    streetNumber: ").append(toIndentedString(streetNumber))
				.append("\n");
		sb.append("    floor: ").append(toIndentedString(floor)).append("\n");
		sb.append("    room: ").append(toIndentedString(room)).append("\n");
		sb.append("    building: ").append(toIndentedString(building))
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
