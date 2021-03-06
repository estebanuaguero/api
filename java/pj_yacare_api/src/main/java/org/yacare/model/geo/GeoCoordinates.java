package org.yacare.model.geo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Coordenadas Geográficas. Ver
 * https://es.wikipedia.org/wiki/Coordenadas_geogr%C3%A1ficas
 */
@ApiModel(description = "Coordenadas Geográficas. Ver https://es.wikipedia.org/wiki/Coordenadas_geogr%C3%A1ficas")
public class GeoCoordinates {

	private Double lat = null;
	private Double lng = null;

	public GeoCoordinates lat(Double lat) {
		this.lat = lat;
		return this;
	}

	/**
	 * Latitud.
	 * 
	 * @return lat
	 **/
	@ApiModelProperty(value = "Latitud.")
	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public GeoCoordinates lng(Double lng) {
		this.lng = lng;
		return this;
	}

	/**
	 * Longitud.
	 * 
	 * @return lng
	 **/
	@ApiModelProperty(value = "Longitud.")
	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GeoCoordinates geoCoordinates = (GeoCoordinates) o;
		return Objects.equals(this.lat, geoCoordinates.lat)
				&& Objects.equals(this.lng, geoCoordinates.lng);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lat, lng);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GeoCoordinates {\n");

		sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
		sb.append("    lng: ").append(toIndentedString(lng)).append("\n");
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
