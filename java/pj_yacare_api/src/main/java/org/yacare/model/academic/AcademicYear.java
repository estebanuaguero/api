package org.yacare.model.academic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.util.Objects;

/**
 * Año Académico
 */
@ApiModel(description = "Año Académico")
public class AcademicYear {

	private String id = null;
	private Boolean erased = null;
	private Integer year = null;
	private String description = null;
	private Date start = null;
	private Date end = null;

	public AcademicYear id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único del año académico.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único del año académico.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AcademicYear erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el año académico fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el año académico fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	// ---------------------------------------------------------------------------

	public AcademicYear year(Integer year) {
		this.year = year;
		return this;
	}

	/**
	 * Año calendário del \"año académico\".
	 * 
	 * @return year
	 **/
	@ApiModelProperty(value = "Año calendário del \"año académico\".")
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	// ---------------------------------------------------------------------------

	public AcademicYear description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Descripción del año académico.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "Descripción del año académico.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// ---------------------------------------------------------------------------

	public AcademicYear start(Date start) {
		this.start = start;
		return this;
	}

	/**
	 * Fecha de comienzo del año académico. Definido en base a RFC3339, ver
	 * https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14
	 * 
	 * @return start
	 **/
	@ApiModelProperty(value = "Fecha de comienzo del año académico. Definido en base a RFC3339, ver https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14")
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public AcademicYear end(Date end) {
		this.end = end;
		return this;
	}

	/**
	 * Fecha de fin del año académico. Definido en base a RFC3339, ver
	 * https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14
	 * 
	 * @return end
	 **/
	@ApiModelProperty(value = "Fecha de fin del año académico. Definido en base a RFC3339, ver https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14")
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
		AcademicYear academicYear = (AcademicYear) o;
		return Objects.equals(this.id, academicYear.id)
				&& Objects.equals(this.erased, academicYear.erased)
				&& Objects.equals(this.year, academicYear.year)
				&& Objects.equals(this.start, academicYear.start)
				&& Objects.equals(this.end, academicYear.end);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, year, start, end);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AcademicYear {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    year: ").append(toIndentedString(year)).append("\n");
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
