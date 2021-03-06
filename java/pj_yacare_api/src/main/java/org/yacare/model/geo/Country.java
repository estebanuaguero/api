package org.yacare.model.geo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * País
 */
@ApiModel(description = "País")
public class Country {
	
	private String id = null;
	private Boolean erased = null;
	private String codeIsoAlfa2 = null;
	private String codeIsoAlfa3 = null;
	private String codeIsoNumber = null;
	private String shortName = null;
	private String name = null;
	private String callingCode = null;
	private String nationalityName = null;

	public Country id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del país.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del país.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Country erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el país fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el país fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public Country codeIsoAlfa2(String codeIsoAlfa2) {
		this.codeIsoAlfa2 = codeIsoAlfa2;
		return this;
	}

	/**
	 * Códigos de país de dos letras. Se recomienda como el código de propósito
	 * general.
	 * 
	 * @return codeIsoAlfa2
	 **/
	@ApiModelProperty(value = "Códigos de país de dos letras. Se recomienda como el código de propósito general.")
	public String getCodeIsoAlfa2() {
		return codeIsoAlfa2;
	}

	public void setCodeIsoAlfa2(String codeIsoAlfa2) {
		this.codeIsoAlfa2 = codeIsoAlfa2;
	}

	public Country codeIsoAlfa3(String codeIsoAlfa3) {
		this.codeIsoAlfa3 = codeIsoAlfa3;
		return this;
	}

	/**
	 * Códigos de país de tres letras. Está más estrechamente relacionado con el
	 * nombre del país, lo que permite una mejor identificación.
	 * 
	 * @return codeIsoAlfa3
	 **/
	@ApiModelProperty(value = "Códigos de país de tres letras. Está más estrechamente relacionado con el nombre del país, lo que permite una mejor identificación.")
	public String getCodeIsoAlfa3() {
		return codeIsoAlfa3;
	}

	public void setCodeIsoAlfa3(String codeIsoAlfa3) {
		this.codeIsoAlfa3 = codeIsoAlfa3;
	}

	public Country codeIsoNumber(String codeIsoNumber) {
		this.codeIsoNumber = codeIsoNumber;
		return this;
	}

	/**
	 * Códigos de país de tres dígitos. Desarrollados y asignados por la
	 * División de Estadística de las Naciones Unidas. Pueden ser útiles cuando
	 * los códigos deban ser entendidos en los países que no utilizan el
	 * alfabeto latino.
	 * 
	 * @return codeIsoNumber
	 **/
	@ApiModelProperty(value = "Códigos de país de tres dígitos. Desarrollados y asignados por la División de Estadística de las Naciones Unidas. Pueden ser útiles cuando los códigos deban ser entendidos en los países que no utilizan el alfabeto latino.")
	public String getCodeIsoNumber() {
		return codeIsoNumber;
	}

	public void setCodeIsoNumber(String codeIsoNumber) {
		this.codeIsoNumber = codeIsoNumber;
	}

	public Country shortName(String shortName) {
		this.shortName = shortName;
		return this;
	}

	/**
	 * Nombre corto o de denominación común, como por ejemplo Argentina.
	 * 
	 * @return shortName
	 **/
	@ApiModelProperty(value = "Nombre corto o de denominación común, como por ejemplo Argentina.")
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Country name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre oficial del país, como por ejemplo República Argentina.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre oficial del país, como por ejemplo República Argentina.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country callingCode(String callingCode) {
		this.callingCode = callingCode;
		return this;
	}

	/**
	 * Prefijo telefónico, para Argentina por ejemplo es +54.
	 * 
	 * @return callingCode
	 **/
	@ApiModelProperty(value = "Prefijo telefónico, para Argentina por ejemplo es +54.")
	public String getCallingCode() {
		return callingCode;
	}

	public void setCallingCode(String callingCode) {
		this.callingCode = callingCode;
	}

	public Country nationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
		return this;
	}

	/**
	 * Ciudadadnía, nacionalidad jurídica, administrativa o de pasaporte; toda
	 * persona considerada como miembro activo de un Estado, titular de derechos
	 * políticos y sometido a sus leyes. Por ejemplo argentino, boliviano,
	 * brasileño, chileno, colombiano, costarricense, cubano, dominicano,
	 * ecuatoriano, español, guatemalteco, hondureño, mexicano, nicaragüense,
	 * panameño, paraguayo, peruano, puertorriqueño, salvadoreño, uruguayo,
	 * venezolano.
	 * 
	 * @return nationalityName
	 **/
	@ApiModelProperty(value = "Ciudadadnía, nacionalidad jurídica, administrativa o de pasaporte; toda persona considerada como miembro activo de un Estado, titular de derechos políticos y sometido a sus leyes. Por ejemplo argentino, boliviano, brasileño, chileno, colombiano, costarricense, cubano, dominicano, ecuatoriano, español, guatemalteco, hondureño, mexicano, nicaragüense, panameño, paraguayo, peruano, puertorriqueño, salvadoreño, uruguayo, venezolano.")
	public String getNationalityName() {
		return nationalityName;
	}

	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Country country = (Country) o;
		return Objects.equals(this.id, country.id)
				&& Objects.equals(this.erased, country.erased)
				&& Objects.equals(this.codeIsoAlfa2, country.codeIsoAlfa2)
				&& Objects.equals(this.codeIsoAlfa3, country.codeIsoAlfa3)
				&& Objects.equals(this.codeIsoNumber, country.codeIsoNumber)
				&& Objects.equals(this.shortName, country.shortName)
				&& Objects.equals(this.name, country.name)
				&& Objects.equals(this.callingCode, country.callingCode)
				&& Objects
						.equals(this.nationalityName, country.nationalityName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, codeIsoAlfa2, codeIsoAlfa3,
				codeIsoNumber, shortName, name, callingCode, nationalityName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Country {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    codeIsoAlfa2: ").append(toIndentedString(codeIsoAlfa2))
				.append("\n");
		sb.append("    codeIsoAlfa3: ").append(toIndentedString(codeIsoAlfa3))
				.append("\n");
		sb.append("    codeIsoNumber: ")
				.append(toIndentedString(codeIsoNumber)).append("\n");
		sb.append("    shortName: ").append(toIndentedString(shortName))
				.append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    callingCode: ").append(toIndentedString(callingCode))
				.append("\n");
		sb.append("    nationalityName: ")
				.append(toIndentedString(nationalityName)).append("\n");
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
