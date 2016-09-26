package org.yacare.model.academic.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Datos referentes al egreso y graduación del estudiante.
 */
@ApiModel(description = "Datos referentes al egreso y graduación del estudiante.")
public class GraduationInstitution {

	private Timestamp date = null;

	public GraduationInstitution date(Timestamp date) {
		this.date = date;
		return this;
	}

	/**
	 * Fecha en la que el estudiante egresó del colegio. Definido en base a
	 * RFC3339, ver
	 * https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14
	 * 
	 * @return date
	 **/
	@ApiModelProperty(value = "Fecha en la que el estudiante egresó del colegio. Definido en base a RFC3339, ver https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14")
	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GraduationInstitution studentGraduationInstitution = (GraduationInstitution) o;
		return Objects.equals(this.date, studentGraduationInstitution.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class StudentGraduationInstitution {\n");

		sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
