package org.yacare.model.academic.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.yacare.model.academic.career.Career;
import org.yacare.model.academic.student.annual_enrollment.AnnualEnrollment;
import org.yacare.model.person.org.Org;
import org.yacare.model.person.physical.Person;

/**
 * Estudiante - Expediente Académico - Legajo Académico
 */
@ApiModel(description = "Estudiante - Expediente Académico - Legajo Académico")
public class Student {

	private String id = null;
	private Boolean erased = null;
	private Person personalInformation = null;
	private Org institution = null;
	private Career career = null;
	private StudentState state = null;
	private InscriptionInstitution inscriptionInstitution = null;
	private AdmissionInstitution admissionInstitution = null;
	private GraduationInstitution graduationInstitution = null;
	private List<AnnualEnrollment> annualEnrollments = new ArrayList<AnnualEnrollment>();
	private List<FamilyLegalGuardian> legalGuardians = new ArrayList<FamilyLegalGuardian>();
	private List<EmergencyContact> emergencyContacts = new ArrayList<EmergencyContact>();

	public Student id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único de estudiante.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único de estudiante.")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Student erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si el estudiante fue borrado o deshabilitado.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si el estudiante fue borrado o deshabilitado.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}

	public Student personalInformation(Person personalInformation) {
		this.personalInformation = personalInformation;
		return this;
	}

	/**
	 * Get personalInformation
	 * 
	 * @return personalInformation
	 **/
	@ApiModelProperty(value = "")
	public Person getPersonalInformation() {
		return personalInformation;
	}

	public void setPersonalInformation(Person personalInformation) {
		this.personalInformation = personalInformation;
	}

	public Student institution(Org institution) {
		this.institution = institution;
		return this;
	}

	/**
	 * Get institution
	 * 
	 * @return institution
	 **/
	@ApiModelProperty(value = "")
	public Org getInstitution() {
		return institution;
	}

	public void setInstitution(Org institution) {
		this.institution = institution;
	}

	public Student career(Career career) {
		this.career = career;
		return this;
	}

	/**
	 * Get career
	 * 
	 * @return career
	 **/
	@ApiModelProperty(value = "")
	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public Student state(StudentState state) {
		this.state = state;
		return this;
	}

	/**
	 * Get state
	 * 
	 * @return state
	 **/
	@ApiModelProperty(value = "")
	public StudentState getState() {
		return state;
	}

	public void setState(StudentState state) {
		this.state = state;
	}

	public Student inscriptionInstitution(
			InscriptionInstitution inscriptionInstitution) {
		this.inscriptionInstitution = inscriptionInstitution;
		return this;
	}

	/**
	 * Get inscriptionInstitution
	 * 
	 * @return inscriptionInstitution
	 **/
	@ApiModelProperty(value = "")
	public InscriptionInstitution getInscriptionInstitution() {
		return inscriptionInstitution;
	}

	public void setInscriptionInstitution(
			InscriptionInstitution inscriptionInstitution) {
		this.inscriptionInstitution = inscriptionInstitution;
	}

	public Student admissionInstitution(
			AdmissionInstitution admissionInstitution) {
		this.admissionInstitution = admissionInstitution;
		return this;
	}

	/**
	 * Get admissionInstitution
	 * 
	 * @return admissionInstitution
	 **/
	@ApiModelProperty(value = "")
	public AdmissionInstitution getAdmissionInstitution() {
		return admissionInstitution;
	}

	public void setAdmissionInstitution(
			AdmissionInstitution admissionInstitution) {
		this.admissionInstitution = admissionInstitution;
	}

	public Student graduationInstitution(
			GraduationInstitution graduationInstitution) {
		this.graduationInstitution = graduationInstitution;
		return this;
	}

	/**
	 * Get graduationInstitution
	 * 
	 * @return graduationInstitution
	 **/
	@ApiModelProperty(value = "")
	public GraduationInstitution getGraduationInstitution() {
		return graduationInstitution;
	}

	public void setGraduationInstitution(
			GraduationInstitution graduationInstitution) {
		this.graduationInstitution = graduationInstitution;
	}

	public Student annualEnrollments(List<AnnualEnrollment> annualEnrollmentList) {
		this.annualEnrollments = annualEnrollmentList;
		return this;
	}

	public Student addAnnualEnrollmentsItem(
			AnnualEnrollment annualEnrollmentListItem) {
		this.annualEnrollments.add(annualEnrollmentListItem);
		return this;
	}

	/**
	 * Get annualEnrollmentList
	 * 
	 * @return annualEnrollmentList
	 **/
	@ApiModelProperty(value = "")
	public List<AnnualEnrollment> getAnnualEnrollments() {
		return annualEnrollments;
	}

	public void setAnnualEnrollments(List<AnnualEnrollment> annualEnrollmentList) {
		this.annualEnrollments = annualEnrollmentList;
	}

	public Student legalGuardians(List<FamilyLegalGuardian> legalGuardians) {
		this.legalGuardians = legalGuardians;
		return this;
	}

	public Student addLegalGuardiansItem(FamilyLegalGuardian legalGuardiansItem) {
		this.legalGuardians.add(legalGuardiansItem);
		return this;
	}

	/**
	 * Get responsibleFamily
	 * 
	 * @return responsibleFamily
	 **/
	@ApiModelProperty(value = "")
	public List<FamilyLegalGuardian> getLegalGuardians() {
		return legalGuardians;
	}

	public void setLegalGuardians(List<FamilyLegalGuardian> legalGuardians) {
		this.legalGuardians = legalGuardians;
	}

	public Student emergencyContacts(List<EmergencyContact> emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
		return this;
	}

	public Student addEmergencyContactsItem(
			EmergencyContact emergencyContactsItem) {
		this.emergencyContacts.add(emergencyContactsItem);
		return this;
	}

	/**
	 * Get emergencyContacts
	 * 
	 * @return emergencyContacts
	 **/
	@ApiModelProperty(value = "")
	public List<EmergencyContact> getEmergencyContacts() {
		return emergencyContacts;
	}

	public void setEmergencyContacts(List<EmergencyContact> emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Student student = (Student) o;
		return Objects.equals(this.id, student.id)
				&& Objects.equals(this.erased, student.erased)
				&& Objects.equals(this.personalInformation,
						student.personalInformation)
				&& Objects.equals(this.institution, student.institution)
				&& Objects.equals(this.career, student.career)
				&& Objects.equals(this.state, student.state)
				&& Objects.equals(this.inscriptionInstitution,
						student.inscriptionInstitution)
				&& Objects.equals(this.admissionInstitution,
						student.admissionInstitution)
				&& Objects.equals(this.graduationInstitution,
						student.graduationInstitution)
				&& Objects.equals(this.annualEnrollments,
						student.annualEnrollments)
				&& Objects.equals(this.legalGuardians, student.legalGuardians)
				&& Objects.equals(this.emergencyContacts,
						student.emergencyContacts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, personalInformation, institution,
				career, state, inscriptionInstitution, admissionInstitution,
				graduationInstitution, annualEnrollments, legalGuardians,
				emergencyContacts);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Student {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    personalInformation: ")
				.append(toIndentedString(personalInformation)).append("\n");
		sb.append("    institution: ").append(toIndentedString(institution))
				.append("\n");
		sb.append("    career: ").append(toIndentedString(career)).append("\n");
		sb.append("    state: ").append(toIndentedString(state)).append("\n");
		sb.append("    inscriptionInstitution: ")
				.append(toIndentedString(inscriptionInstitution)).append("\n");
		sb.append("    admissionInstitution: ")
				.append(toIndentedString(admissionInstitution)).append("\n");
		sb.append("    graduationInstitution: ")
				.append(toIndentedString(graduationInstitution)).append("\n");
		sb.append("    annualEnrollmentList: ")
				.append(toIndentedString(annualEnrollments)).append("\n");
		sb.append("    responsibleFamily: ")
				.append(toIndentedString(legalGuardians)).append("\n");
		sb.append("    emergencyContacts: ")
				.append(toIndentedString(emergencyContacts)).append("\n");
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
