package org.yacare.model.person.communication_options.phone;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Números de teléfono.
 */
@ApiModel(description = "Números de teléfono.")
public class Phones {

	private Phone mainPhone = null;
	private List<Phone> alternativePhones = new ArrayList<Phone>();
	private String summary = null;

	public Phones mainPhone(Phone mainPhone) {
		this.mainPhone = mainPhone;
		return this;
	}

	/**
	 * Get mainPhone
	 * 
	 * @return mainPhone
	 **/
	@ApiModelProperty(value = "")
	public Phone getMainPhone() {
		return mainPhone;
	}

	public void setMainPhone(Phone mainPhone) {
		this.mainPhone = mainPhone;
	}

	public Phones alternativePhones(List<Phone> alternativePhones) {
		this.alternativePhones = alternativePhones;
		return this;
	}

	public Phones addAlternativePhonesItem(Phone alternativePhonesItem) {
		this.alternativePhones.add(alternativePhonesItem);
		return this;
	}

	/**
	 * Get alternativePhones
	 * 
	 * @return alternativePhones
	 **/
	@ApiModelProperty(value = "")
	public List<Phone> getAlternativePhones() {
		return alternativePhones;
	}

	public void setAlternativePhones(List<Phone> alternativePhones) {
		this.alternativePhones = alternativePhones;
	}

	public Phones summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida de los teléfonos.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida de los teléfonos.")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Phones personCommunicationOptionsPhones = (Phones) o;
		return Objects.equals(this.mainPhone,
				personCommunicationOptionsPhones.mainPhone)
				&& Objects.equals(this.alternativePhones,
						personCommunicationOptionsPhones.alternativePhones)
				&& Objects.equals(this.summary,
						personCommunicationOptionsPhones.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mainPhone, alternativePhones, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PersonCommunicationOptionsPhones {\n");

		sb.append("    mainPhone: ").append(toIndentedString(mainPhone))
				.append("\n");
		sb.append("    alternativePhones: ")
				.append(toIndentedString(alternativePhones)).append("\n");
		sb.append("    summary: ").append(toIndentedString(summary))
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
