package org.yacare.model.person.physical;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import org.yacare.model.health.BloodFactor;
import org.yacare.model.health.BloodGroup;
import org.yacare.model.health.HealthCoverage;

/**
 * Datos de médicos de la persona, como factor y grupo sanguineo, cobertura
 * médica, etc.
 */
@ApiModel(description = "Datos de médicos de la persona, como factor y grupo sanguineo, cobertura médica, etc.")
public class PersonHealthData {

	private BloodFactor bloodFactor = null;
	private BloodGroup bloodGroup = null;
	private HealthCoverage healthCoverage = null;

	public PersonHealthData bloodFactor(BloodFactor bloodFactor) {
		this.bloodFactor = bloodFactor;
		return this;
	}

	/**
	 * Get bloodFactor
	 * 
	 * @return bloodFactor
	 **/
	@ApiModelProperty(value = "")
	public BloodFactor getBloodFactor() {
		return bloodFactor;
	}

	public void setBloodFactor(BloodFactor bloodFactor) {
		this.bloodFactor = bloodFactor;
	}

	public PersonHealthData bloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
		return this;
	}

	/**
	 * Get bloodGroup
	 * 
	 * @return bloodGroup
	 **/
	@ApiModelProperty(value = "")
	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public PersonHealthData healthCoverage(HealthCoverage healthCoverage) {
		this.healthCoverage = healthCoverage;
		return this;
	}

	/**
	 * Get healthCoverage
	 * 
	 * @return healthCoverage
	 **/
	@ApiModelProperty(value = "")
	public HealthCoverage getHealthCoverage() {
		return healthCoverage;
	}

	public void setHealthCoverage(HealthCoverage healthCoverage) {
		this.healthCoverage = healthCoverage;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PersonHealthData personHealthData = (PersonHealthData) o;
		return Objects.equals(this.bloodFactor, personHealthData.bloodFactor)
				&& Objects.equals(this.bloodGroup, personHealthData.bloodGroup)
				&& Objects.equals(this.healthCoverage,
						personHealthData.healthCoverage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bloodFactor, bloodGroup, healthCoverage);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PersonHealthData {\n");

		sb.append("    bloodFactor: ").append(toIndentedString(bloodFactor))
				.append("\n");
		sb.append("    bloodGroup: ").append(toIndentedString(bloodGroup))
				.append("\n");
		sb.append("    healthCoverage: ")
				.append(toIndentedString(healthCoverage)).append("\n");
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
