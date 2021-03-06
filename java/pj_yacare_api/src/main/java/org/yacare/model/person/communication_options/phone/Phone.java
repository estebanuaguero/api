package org.yacare.model.person.communication_options.phone;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.yacare.model.geo.Country;

/**
 * Número de Teléfono
 */
@ApiModel(description = "Número de Teléfono")
public class Phone {

	private String id = null;
	private Boolean erased = null;
	private Country country = null;
	private String localCallingCode = null;
	private String number = null;
	private String comment = null;
	private String summary = null;
	private PhoneType phoneType = null;

	public Phone id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del teléfono.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del teléfono.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Phone erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el teléfono fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el teléfono fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public Phone country(Country country) {
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

	public Phone localCallingCode(String localCallingCode) {
		this.localCallingCode = localCallingCode;
		return this;
	}

	/**
	 * Prefijo telefónico, para la ciudad de Córdoba es 0351.
	 * 
	 * @return localCallingCode
	 **/
	@ApiModelProperty(value = "Prefijo telefónico, para la ciudad de Córdoba es 0351.")
	public String getLocalCallingCode() {
		return localCallingCode;
	}

	public void setLocalCallingCode(String localCallingCode) {
		this.localCallingCode = localCallingCode;
	}

	public Phone number(String number) {
		this.number = number;
		return this;
	}

	/**
	 * Número de teléfono.
	 * 
	 * @return number
	 **/
	@ApiModelProperty(value = "Número de teléfono.")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Phone comment(String comment) {
		this.comment = comment;
		return this;
	}

	/**
	 * Comentarios o aclaraciones del contacto.
	 * 
	 * @return comment
	 **/
	@ApiModelProperty(value = "Comentarios o aclaraciones del contacto.")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Phone summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del teléfono.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del teléfono.")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Phone phoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
		return this;
	}

	/**
	 * Get phoneType
	 * 
	 * @return phoneType
	 **/
	@ApiModelProperty(value = "")
	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Phone phone = (Phone) o;
		return Objects.equals(this.id, phone.id)
				&& Objects.equals(this.erased, phone.erased)
				&& Objects.equals(this.country, phone.country)
				&& Objects
						.equals(this.localCallingCode, phone.localCallingCode)
				&& Objects.equals(this.number, phone.number)
				&& Objects.equals(this.comment, phone.comment)
				&& Objects.equals(this.summary, phone.summary)
				&& Objects.equals(this.phoneType, phone.phoneType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, country, localCallingCode, number,
				comment, summary, phoneType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Phone {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    country: ").append(toIndentedString(country))
				.append("\n");
		sb.append("    localCallingCode: ")
				.append(toIndentedString(localCallingCode)).append("\n");
		sb.append("    number: ").append(toIndentedString(number)).append("\n");
		sb.append("    comment: ").append(toIndentedString(comment))
				.append("\n");
		sb.append("    summary: ").append(toIndentedString(summary))
				.append("\n");
		sb.append("    phoneType: ").append(toIndentedString(phoneType))
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
