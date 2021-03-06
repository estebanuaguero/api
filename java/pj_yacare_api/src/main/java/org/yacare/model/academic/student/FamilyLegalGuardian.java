package org.yacare.model.academic.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.yacare.model.academic.student.legal_guardian.EducationLevel;
import org.yacare.model.person.physical.PersonId;

/**
 * Tutor de un estudiante
 */
@ApiModel(description = "Tutor de un estudiante")
public class FamilyLegalGuardian {

	private PersonId person = null;
	private FamilyRelationshipType familyRelationshipType = null;
	private EducationLevel educationLevel = null;

	public FamilyLegalGuardian person(PersonId person) {
		this.person = person;
		return this;
	}

	/**
	 * Get person
	 * 
	 * @return person
	 **/
	@ApiModelProperty(value = "")
	public PersonId getPerson() {
		return person;
	}

	public void setPerson(PersonId person) {
		this.person = person;
	}

	public FamilyLegalGuardian familyRelationshipType(
			FamilyRelationshipType familyRelationshipType) {
		this.familyRelationshipType = familyRelationshipType;
		return this;
	}

	/**
	 * Get familyRelationshipType
	 * 
	 * @return familyRelationshipType
	 **/
	@ApiModelProperty(value = "")
	public FamilyRelationshipType getFamilyRelationshipType() {
		return familyRelationshipType;
	}

	public void setFamilyRelationshipType(
			FamilyRelationshipType familyRelationshipType) {
		this.familyRelationshipType = familyRelationshipType;
	}

	public FamilyLegalGuardian educationLevel(EducationLevel educationLevel) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FamilyLegalGuardian responsibleFamily = (FamilyLegalGuardian) o;
		return Objects.equals(this.person, responsibleFamily.person)
				&& Objects.equals(this.familyRelationshipType,
						responsibleFamily.familyRelationshipType)
				&& Objects.equals(this.educationLevel,
						responsibleFamily.educationLevel);
	}

	@Override
	public int hashCode() {
		return Objects.hash(person, familyRelationshipType, educationLevel);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResponsibleFamily {\n");

		sb.append("    person: ").append(toIndentedString(person)).append("\n");
		sb.append("    familyRelationshipType: ")
				.append(toIndentedString(familyRelationshipType)).append("\n");
		sb.append("    educationLevel: ")
				.append(toIndentedString(educationLevel)).append("\n");

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
