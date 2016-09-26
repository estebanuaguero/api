package org.yacare.model.academic.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Datos referentes a la admisión del estudiante.
 */
@ApiModel(description = "Datos referentes a la admisión del estudiante.")
public class AdmissionInstitution {

	private Timestamp date = null;

	public AdmissionInstitution date(Timestamp date) {
		this.date = date;
		return this;
	}

	/**
	 * Fecha en la que el estudiante fue admitido en el colegio. Definido en
	 * base a RFC3339, ver
	 * https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14
	 * 
	 * @return date
	 **/
	@ApiModelProperty(value = "Fecha en la que el estudiante fue admitido en el colegio. Definido en base a RFC3339, ver https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14")
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
		AdmissionInstitution studentAdmissionInstitution = (AdmissionInstitution) o;
		return Objects.equals(this.date, studentAdmissionInstitution.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class StudentAdmissionInstitution {\n");

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
