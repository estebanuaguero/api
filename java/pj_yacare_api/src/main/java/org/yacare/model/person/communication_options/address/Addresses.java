package org.yacare.model.person.communication_options.address;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.yacare.model.geo.Address;

/**
 * Domicilios.
 */
@ApiModel(description = "Domicilios.")
public class Addresses {
	
	private Address mainAddress = null;
	private List<Address> alternativeAddresses = new ArrayList<Address>();
	private String summary = null;

	public Addresses mainAddress(Address mainAddress) {
		this.mainAddress = mainAddress;
		return this;
	}

	/**
	 * Get mainAddress
	 * 
	 * @return mainAddress
	 **/
	@ApiModelProperty(value = "")
	public Address getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(Address mainAddress) {
		this.mainAddress = mainAddress;
	}

	public Addresses alternativeAddresses(List<Address> alternativeAddresses) {
		this.alternativeAddresses = alternativeAddresses;
		return this;
	}

	public Addresses addAlternativeAddressesItem(
			Address alternativeAddressesItem) {
		this.alternativeAddresses.add(alternativeAddressesItem);
		return this;
	}

	/**
	 * Get alternativeAddresses
	 * 
	 * @return alternativeAddresses
	 **/
	@ApiModelProperty(value = "")
	public List<Address> getAlternativeAddresses() {
		return alternativeAddresses;
	}

	public void setAlternativeAddresses(List<Address> alternativeAddresses) {
		this.alternativeAddresses = alternativeAddresses;
	}

	public Addresses summary(String summary) {
		this.summary = summary;
		return this;
	}

	/**
	 * Presentación resumida de los domicilios.
	 * 
	 * @return summary
	 **/
	@ApiModelProperty(value = "Presentación resumida de los domicilios.")
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
		Addresses personCommunicationOptionsAddresses = (Addresses) o;
		return Objects.equals(this.mainAddress,
				personCommunicationOptionsAddresses.mainAddress)
				&& Objects
						.equals(this.alternativeAddresses,
								personCommunicationOptionsAddresses.alternativeAddresses)
				&& Objects.equals(this.summary,
						personCommunicationOptionsAddresses.summary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mainAddress, alternativeAddresses, summary);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PersonCommunicationOptionsAddresses {\n");

		sb.append("    mainAddress: ").append(toIndentedString(mainAddress))
				.append("\n");
		sb.append("    alternativeAddresses: ")
				.append(toIndentedString(alternativeAddresses)).append("\n");
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
