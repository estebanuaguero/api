package org.yacare.model.geo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Área Administrativa de 1er Nivel - Provincia, Estado
 */
@ApiModel(description = "Área Administrativa de 1er Nivel - Provincia, Estado")
public class AdminAreaLevel1 {
	
	private String isoCode = null;
	private String name = null;

	public AdminAreaLevel1 isoCode(String isoCode) {
		this.isoCode = isoCode;
		return this;
	}

	/**
	 * Código ISO 3166-2, que es la segunda parte del estándar internacional de
	 * normalización ISO 3166, que define los códigos de identificación de las
	 * principales subdivisiones (por ejemplo, provincias o estados) de todos
	 * los países codificados en ISO 3166-1
	 * 
	 * @return isoCode
	 **/
	@ApiModelProperty(value = "Código ISO 3166-2, que es la segunda parte del estándar internacional de normalización ISO 3166, que define los códigos de identificación de las principales subdivisiones (por ejemplo, provincias o estados) de todos los países codificados en ISO 3166-1")
	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public AdminAreaLevel1 name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del área administrativa, por ejemplo Córdoba, Santa Cruz, Río
	 * Negro, Chubut.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del área administrativa, por ejemplo Córdoba, Santa Cruz, Río Negro, Chubut.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AdminAreaLevel1 adminAreaLevel1 = (AdminAreaLevel1) o;
		return Objects.equals(this.isoCode, adminAreaLevel1.isoCode)
				&& Objects.equals(this.name, adminAreaLevel1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(isoCode, name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AdminAreaLevel1 {\n");

		sb.append("    isoCode: ").append(toIndentedString(isoCode))
				.append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
