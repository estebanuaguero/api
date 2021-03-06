package org.yacare.model.academic.student.legal_guardian;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.yacare.model.person.physical.Person;

/**
 * Tutor de un estudiante
 */
@ApiModel(description = "Tutor de un estudiante")
public class LegalGuardian {

	private Person personalInformation = null;
	private EducationLevel educationLevel = null;
	private String comment = null;
	private String summary = null;
	private List<FamilyStudent> students = new ArrayList<FamilyStudent>();

	public LegalGuardian personalInformation(Person personalInformation) {
		this.personalInformation = personalInformation;
		return this;
	}

	/**
	 * Get person
	 * 
	 * @return person
	 **/
	@ApiModelProperty(value = "")
	public Person getPersonalInformation() {
		return personalInformation;
	}

	public void setPersonalInformation(Person personalInformation) {
		this.personalInformation = personalInformation;
	}

	public LegalGuardian educationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
		return this;
	}

	/**
	 * Get educationLevel
	 * 
	 * @return educationLevel
	 **/
	@ApiModelProperty(value = "")
	public EducationLevel getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
	}

	public LegalGuardian comment(String comment) {
		this.comment = comment;
		return this;
	}

	/**
	 * Comentarios o aclaraciones del tutor.
	 * 
	 * @return comment
	 **/
	@ApiModelProperty(value = "Comentarios o aclaraciones del tutor.")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LegalGuardian summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida del tutor.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida del tutor.")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public LegalGuardian students(List<FamilyStudent> students) {
		this.students = students;
		return this;
	}

	public LegalGuardian addStudentsItem(FamilyStudent studentsItem) {
		this.students.add(studentsItem);
		return this;
	}

	/**
	 * Get students
	 * 
	 * @return students
	 **/
	@ApiModelProperty(value = "")
	public List<FamilyStudent> getStudents() {
		return students;
	}

	public void setStudents(List<FamilyStudent> students) {
		this.students = students;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LegalGuardian legalGuardian = (LegalGuardian) o;
		return Objects.equals(this.personalInformation, legalGuardian.personalInformation)
				&& Objects.equals(this.educationLevel,
						legalGuardian.educationLevel)
				&& Objects.equals(this.comment, legalGuardian.comment)
				&& Objects.equals(this.summary, legalGuardian.summary)
				&& Objects.equals(this.students, legalGuardian.students);
	}

	@Override
	public int hashCode() {
		return Objects.hash(personalInformation, educationLevel, comment, summary, students);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class LegalGuardian {\n");

		sb.append("    person: ").append(toIndentedString(personalInformation)).append("\n");
		sb.append("    educationLevel: ")
				.append(toIndentedString(educationLevel)).append("\n");
		sb.append("    comment: ").append(toIndentedString(comment))
				.append("\n");
		sb.append("    summary: ").append(toIndentedString(summary))
				.append("\n");
		sb.append("    students: ").append(toIndentedString(students))
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
