package org.yacare.model.academic.student.annual_enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Datos referentes a la admisión y a la confirmación de la matrícula anual del
 * estudiante.
 */
@ApiModel(description = "Datos referentes a la admisión y a la confirmación de la matrícula anual del estudiante.")
public class AdmissionEnrollment {

	private Timestamp admissionDate = null;
	private Timestamp enrollmentDate = null;

	public AdmissionEnrollment admissionDate(
			Timestamp admissionDate) {
		this.admissionDate = admissionDate;
		return this;
	}

	/**
	 * Fecha en la que se creó la matrícula, es decir el estudiante fue admitido
	 * en el colegio al año académico establecido en dicha matrícula. Definido
	 * en base a RFC3339, ver
	 * https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14
	 * 
	 * @return admissionDate
	 **/
	@ApiModelProperty(value = "Fecha en la que se creó la matrícula, es decir el estudiante fue admitido en el colegio al año académico establecido en dicha matrícula. Definido en base a RFC3339, ver https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14")
	public Timestamp getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Timestamp admissionDate) {
		this.admissionDate = admissionDate;
	}

	public AdmissionEnrollment enrollmentDate(
			Timestamp enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
		return this;
	}

	/**
	 * Fecha en la que se confirmó la matrícula, es decir el estudiante ha
	 * confirmado que cursará en el colegio en el año académico establecido en
	 * dicha matrícula. Definido en base a RFC3339, ver
	 * https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14
	 * 
	 * @return enrollmentDate
	 **/
	@ApiModelProperty(value = "Fecha en la que se confirmó la matrícula, es decir el estudiante ha confirmado que cursará en el colegio en el año académico establecido en dicha matrícula. Definido en base a RFC3339, ver https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14")
	public Timestamp getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(Timestamp enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AdmissionEnrollment annualEnrollmentAdmissionEnrollment = (AdmissionEnrollment) o;
		return Objects.equals(this.admissionDate,
				annualEnrollmentAdmissionEnrollment.admissionDate)
				&& Objects.equals(this.enrollmentDate,
						annualEnrollmentAdmissionEnrollment.enrollmentDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(admissionDate, enrollmentDate);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AnnualEnrollmentAdmissionEnrollment {\n");

		sb.append("    admissionDate: ")
				.append(toIndentedString(admissionDate)).append("\n");
		sb.append("    enrollmentDate: ")
				.append(toIndentedString(enrollmentDate)).append("\n");
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
