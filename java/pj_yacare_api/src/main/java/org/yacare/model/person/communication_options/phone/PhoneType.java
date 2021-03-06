package org.yacare.model.person.communication_options.phone;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Tipo de teléfono. Ej. Casa, Móvil, Trabajo, Otro.
 */
@ApiModel(description = "Tipo de teléfono. Ej. Casa, Móvil, Trabajo, Otro.")
public class PhoneType {

	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;

	public PhoneType id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del tipo de teléfono.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del tipo de teléfono.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PhoneType erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el tipo de teléfono fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el tipo de teléfono fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public PhoneType code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código del tipo de teléfono.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código del tipo de teléfono.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public PhoneType name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del tipo de teléfono.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del tipo de teléfono.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PhoneType description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción del tipo de teléfono.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción del tipo de teléfono.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PhoneType summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del tipo de teléfono.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del tipo de teléfono.")
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
		PhoneType phoneType = (PhoneType) o;
		return Objects.equals(this.id, phoneType.id)
				&& Objects.equals(this.erased, phoneType.erased)
				&& Objects.equals(this.code, phoneType.code)
				&& Objects.equals(this.name, phoneType.name)
				&& Objects.equals(this.description, phoneType.description)
				&& Objects.equals(this.summary, phoneType.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PhoneType {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description))
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
