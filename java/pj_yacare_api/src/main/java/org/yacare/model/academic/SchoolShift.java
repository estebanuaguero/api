package org.yacare.model.academic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.util.Objects;

/**
 * Turno Escolar
 */
@ApiModel(description = "Turno Escolar")
public class SchoolShift {

	private String id = null;
	private Boolean erased = null;
	private String code = null;
	private String name = null;
	private String description = null;
	private String summary = null;
	private Date start = null;
	private Date end = null;
	
	public SchoolShift id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del turno escolar.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del turno escolar.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SchoolShift erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el turno escolar fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el turno escolar fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public SchoolShift code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Código del turno escolar.
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Código del turno escolar.")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public SchoolShift name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Nombre del turno escolar.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "Nombre del turno escolar.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SchoolShift description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción del turno escolar.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción del turno escolar.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SchoolShift summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del turno escolar.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del turno escolar.")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public SchoolShift start(Date start) {
		this.start = start;
		return this;
	}

	/**
	 * Hora de comienzo del turno escolar. Definido en base a RFC3339, ver
	 * https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14
	 * 
	 * @return start
	 **/
	@ApiModelProperty(value = "Hora de comienzo del turno escolar. Definido en base a RFC3339, ver https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14")
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public SchoolShift end(Date end) {
		this.end = end;
		return this;
	}

	/**
	 * Hora de fin del turno escolar. Definido en base a RFC3339, ver
	 * https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14
	 * 
	 * @return end
	 **/
	@ApiModelProperty(value = "Hora de fin del turno escolar. Definido en base a RFC3339, ver https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14")
	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SchoolShift schoolShift = (SchoolShift) o;
		return Objects.equals(this.id, schoolShift.id)
				&& Objects.equals(this.erased, schoolShift.erased)
				&& Objects.equals(this.code, schoolShift.code)
				&& Objects.equals(this.name, schoolShift.name)
				&& Objects.equals(this.description, schoolShift.description)
				&& Objects.equals(this.summary, schoolShift.summary)
				&& Objects.equals(this.start, schoolShift.start)
				&& Objects.equals(this.end, schoolShift.end);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, code, name, description, summary,
				start, end);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SchoolShift {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description))
				.append("\n");
		sb.append("    summary: ").append(toIndentedString(summary))
				.append("\n");
		sb.append("    start: ").append(toIndentedString(start)).append("\n");
		sb.append("    end: ").append(toIndentedString(end)).append("\n");
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
