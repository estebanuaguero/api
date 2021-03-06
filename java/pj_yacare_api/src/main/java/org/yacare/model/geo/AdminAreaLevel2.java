package org.yacare.model.geo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Área Administrativa de 2do Nivel - Departamento, Partido
 */
@ApiModel(description = "Área Administrativa de 2do Nivel - Departamento, Partido")
public class AdminAreaLevel2 {

	private String code = null;
	private String name = null;

	public AdminAreaLevel2 code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código del Área Administrativa.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código del Área Administrativa.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AdminAreaLevel2 name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del área administrativa, por ejemplo Capital, Calamuchita,
	 * Punilla, Río Cuarto. Ver
	 * https://es.wikipedia.org/wiki/Anexo:Departamentos_de_la_provincia_de_C
	 * %C3%B3rdoba
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del área administrativa, por ejemplo Capital, Calamuchita, Punilla, Río Cuarto. Ver https://es.wikipedia.org/wiki/Anexo:Departamentos_de_la_provincia_de_C%C3%B3rdoba")
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
		AdminAreaLevel2 adminAreaLevel2 = (AdminAreaLevel2) o;
		return Objects.equals(this.code, adminAreaLevel2.code)
				&& Objects.equals(this.name, adminAreaLevel2.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AdminAreaLevel2 {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
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
