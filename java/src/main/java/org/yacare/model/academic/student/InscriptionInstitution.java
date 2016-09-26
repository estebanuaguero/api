package org.yacare.model.academic.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.Objects;

import org.yacare.model.person.org.Org;

/**
 * Datos referentes a la inscripción del estudiante.
 */
@ApiModel(description = "Datos referentes a la inscripción del estudiante.")
public class InscriptionInstitution {

	private Timestamp date = null;
	private Org fromInstitution = null;

	public InscriptionInstitution date(Timestamp date) {
		this.date = date;
		return this;
	}

	/**
	 * Fecha en la que el estudiante se inscribió en el colegio. Definido en
	 * base a RFC3339, ver
	 * https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14
	 * 
	 * @return date
	 **/
	@ApiModelProperty(value = "Fecha en la que el estudiante se inscribió en el colegio. Definido en base a RFC3339, ver https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14")
	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public InscriptionInstitution fromInstitution(Org fromInstitution) {
		this.fromInstitution = fromInstitution;
		return this;
	}

	/**
	 * Get fromInstitution
	 * 
	 * @return fromInstitution
	 **/
	@ApiModelProperty(value = "")
	public Org getFromInstitution() {
		return fromInstitution;
	}

	public void setFromInstitution(Org fromInstitution) {
		this.fromInstitution = fromInstitution;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InscriptionInstitution studentInscriptionInstitution = (InscriptionInstitution) o;
		return Objects.equals(this.date, studentInscriptionInstitution.date)
				&& Objects.equals(this.fromInstitution,
						studentInscriptionInstitution.fromInstitution);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, fromInstitution);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class StudentInscriptionInstitution {\n");

		sb.append("    date: ").append(toIndentedString(date)).append("\n");
		sb.append("    fromInstitution: ")
				.append(toIndentedString(fromInstitution)).append("\n");
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
