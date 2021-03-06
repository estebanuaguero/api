package org.yacare.model.person.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.yacare.model.geo.Country;

/**
 * Organización
 */
@ApiModel(description = "Organización")
public class Org {

	private String id = null;
	private Boolean erased = null;
	private String shortName = null;
	private String name = null;
	private String urlPhoto = null;
	private String webSite = null;
	private String description = null;
	private Country country = null;

	public Org id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único de la organización.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador  (UUID) único de la organización.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Org erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si la organización fue borrada o deshabilitada.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si la organización fue borrada o deshabilitada.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public Org shortName(String shortName) {
		this.shortName = shortName;
		return this;
	}

	/**
	 * Sigla de la organización, como por ejemplo CNM | UNC | IUA.
	 * 
	 * @return shortName
	 **/
	@ApiModelProperty(value = "Sigla de la organización, como por ejemplo CNM | UNC | IUA.")
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Org name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre de la organización, como por ejemplo Colegio Nacioanl de
	 * Monserrat.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre de la organización, como por ejemplo Colegio Nacioanl de Monserrat.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Org urlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
		return this;
	}

	/**
	 * URL del logo de la organización.
	 * 
	 * @return urlPhoto
	 **/
	@ApiModelProperty(value = "URL del logo de la organización.")
	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public Org webSite(String webSite) {
		this.webSite = webSite;
		return this;
	}

	/**
	 * URL del sitio Web de la organización.
	 * 
	 * @return webSite
	 **/
	@ApiModelProperty(value = "URL del sitio Web de la organización.")
	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Org description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción de la organización, como por ejemplo nombres alternativos al
	 * oficial, o comentarios generales.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción de la organización, como por ejemplo nombres alternativos al oficial, o comentarios generales.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Org country(Country country) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Org org = (Org) o;
		return Objects.equals(this.id, org.id)
				&& Objects.equals(this.erased, org.erased)
				&& Objects.equals(this.shortName, org.shortName)
				&& Objects.equals(this.name, org.name)
				&& Objects.equals(this.urlPhoto, org.urlPhoto)
				&& Objects.equals(this.webSite, org.webSite)
				&& Objects.equals(this.description, org.description)
				&& Objects.equals(this.country, org.country);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, shortName, name, urlPhoto, webSite,
				description, country);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Org {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    shortName: ").append(toIndentedString(shortName))
				.append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    urlPhoto: ").append(toIndentedString(urlPhoto))
				.append("\n");
		sb.append("    webSite: ").append(toIndentedString(webSite))
				.append("\n");
		sb.append("    description: ").append(toIndentedString(description))
				.append("\n");
		sb.append("    country: ").append(toIndentedString(country))
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
