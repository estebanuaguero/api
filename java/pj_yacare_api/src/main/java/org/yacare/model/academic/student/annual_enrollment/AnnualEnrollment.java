package org.yacare.model.academic.student.annual_enrollment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.yacare.model.academic.AcademicYear;
import org.yacare.model.academic.SchoolShift;
import org.yacare.model.academic.career.Period;

/**
 * Matrícula Escolar Anual del Estudiante
 */
@ApiModel(description = "Matrícula Escolar Anual del Estudiante")
public class AnnualEnrollment {

	private String id = null;
	private Boolean erased = null;
	private AcademicYear academicYear = null;	
	private Period period = null;
//	private AdmissionEnrollment admissionEnrollment = null;	
	private SchoolShift mainSchoolShift = null;
	private AnnualEnrollmentState state = null;

	public AnnualEnrollment id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único de la matrícula anual del estudiante.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único de la matrícula anual del estudiante.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AnnualEnrollment erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si la matrícula anual del estudiante fue borrada o
	 * deshabilitada.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si la matrícula anual del estudiante fue borrada o deshabilitada.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public AnnualEnrollment academicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
		return this;
	}

	/**
	 * Get academicYear
	 * 
	 * @return academicYear
	 **/
	@ApiModelProperty(value = "")
	public AcademicYear getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(AcademicYear academicYear) {
		this.academicYear = academicYear;
	}

	public AnnualEnrollment period(Period period) {
		this.period = period;
		return this;
	}

	/**
	 * Get period
	 * 
	 * @return period
	 **/
//	@ApiModelProperty(value = "")
//	public Period getPeriod() {
//		return period;
//	}
//
//	public void setPeriod(Period period) {
//		this.period = period;
//	}
//
//	public AnnualEnrollment admissionEnrollment(
//			AdmissionEnrollment admissionEnrollment) {
//		this.admissionEnrollment = admissionEnrollment;
//		return this;
//	}

	/**
	 * Get admissionEnrollment
	 * 
	 * @return admissionEnrollment
	 **/
//	@ApiModelProperty(value = "")
//	public AdmissionEnrollment getAdmissionEnrollment() {
//		return admissionEnrollment;
//	}
//
//	public void setAdmissionEnrollment(
//			AdmissionEnrollment admissionEnrollment) {
//		this.admissionEnrollment = admissionEnrollment;
//	}
//
//	public AnnualEnrollment mainSchoolShift(SchoolShift mainSchoolShift) {
//		this.mainSchoolShift = mainSchoolShift;
//		return this;
//	}

	/**
	 * Get mainSchoolShift
	 * 
	 * @return mainSchoolShift
	 **/
	@ApiModelProperty(value = "")
	public SchoolShift getMainSchoolShift() {
		return mainSchoolShift;
	}

	public void setMainSchoolShift(SchoolShift mainSchoolShift) {
		this.mainSchoolShift = mainSchoolShift;
	}

	public AnnualEnrollment state(AnnualEnrollmentState state) {
		this.state = state;
		return this;
	}

	/**
	 * Get state
	 * 
	 * @return state
	 **/
	@ApiModelProperty(value = "")
	public AnnualEnrollmentState getState() {
		return state;
	}

	public void setState(AnnualEnrollmentState state) {
		this.state = state;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AnnualEnrollment annualEnrollment = (AnnualEnrollment) o;
		return Objects.equals(this.id, annualEnrollment.id)
				&& Objects.equals(this.erased, annualEnrollment.erased)
				&& Objects.equals(this.academicYear,
						annualEnrollment.academicYear)
				&& Objects.equals(this.period, annualEnrollment.period)
//				&& Objects.equals(this.admissionEnrollment,
//						annualEnrollment.admissionEnrollment)
				&& Objects.equals(this.mainSchoolShift,
						annualEnrollment.mainSchoolShift)
				&& Objects.equals(this.state, annualEnrollment.state);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, academicYear, period,
				/*admissionEnrollment,*/ mainSchoolShift, state);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class AnnualEnrollment {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    academicYear: ").append(toIndentedString(academicYear))
				.append("\n");
		sb.append("    period: ").append(toIndentedString(period)).append("\n");
//		sb.append("    admissionEnrollment: ")
//				.append(toIndentedString(admissionEnrollment)).append("\n");
		sb.append("    mainSchoolShift: ")
				.append(toIndentedString(mainSchoolShift)).append("\n");
		sb.append("    state: ").append(toIndentedString(state)).append("\n");
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
