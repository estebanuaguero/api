package org.yacare.model.academic.student.legal_guardian;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.yacare.model.academic.student.FamilyRelationshipType;
import org.yacare.model.person.physical.PersonId;

/**
 * Estudiante a cargo de un tutor
 */
@ApiModel(description = "Estudiante a cargo de un tutor")
public class FamilyStudent {

	private PersonId person = null;
	private FamilyRelationshipType familyRelationshipType = null;

	public FamilyStudent person(PersonId person) {
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

	public FamilyStudent familyRelationshipType(
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FamilyStudent responsibleFamily = (FamilyStudent) o;
		return Objects.equals(this.person, responsibleFamily.person)
				&& Objects.equals(this.familyRelationshipType,
						responsibleFamily.familyRelationshipType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(person, familyRelationshipType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResponsibleFamily {\n");

		sb.append("    person: ").append(toIndentedString(person)).append("\n");
		sb.append("    familyRelationshipType: ")
				.append(toIndentedString(familyRelationshipType)).append("\n");

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
