package org.yacare.model.person.physical;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.yacare.model.person.communication_options.CommunicationOptions;
import org.yacare.model.person.identity_document.IdentityDocuments;
import org.yacare.model.person.nationality.Nationalities;

/**
 * Persona
 */
@ApiModel(description = "Persona")
public class Person {

	private String id = null;
	private Boolean erased = null;
	private String urlPhoto = null;
	private List<String> givenNames = new ArrayList<String>();
	private List<String> surnames = new ArrayList<String>();
	private PersonGender gender = null;
	private PersonBirth birth = null;
	private Nationalities nationalities = null;
	private IdentityDocuments identityDocuments = null;
	private CommunicationOptions communicationOptions = new CommunicationOptions();
	private PersonHealthData healthData = null;

	public Person id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identificador (UUID) único de la persona.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Identificador (UUID) único de la persona.")
	public String getId() {
		urlPhoto = "/students/" + id + "/photos/" + id;
		return id;
	}

	public void setId(String id) {
		this.id = id;
		urlPhoto = "/students/" + id + "/photos/" + id;
	}

	public Person erased(Boolean erased) {
		this.erased = erased;
		return this;
	}

	/**
	 * Determina si la persona fue borrada o deshabilitada.
	 * 
	 * @return erased
	 **/
	@ApiModelProperty(value = "Determina si la persona fue borrada o deshabilitada.")
	public Boolean getErased() {
		return erased;
	}

	public void setErased(Boolean erased) {
		this.erased = erased;
	}



	/**
	 * URL de la foto personal.
	 * 
	 * @return urlPhoto
	 **/
	@ApiModelProperty(value = "URL de la foto personal.")
	public String getUrlPhoto() {
		urlPhoto = "/students/" + id + "/photos/" + id;
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		urlPhoto = "/students/" + id + "/photos/" + id;
		this.urlPhoto = urlPhoto;
	}

	public Person givenNames(List<String> givenNames) {
		this.givenNames = givenNames;
		return this;
	}

	public Person addGivenNamesItem(String givenNamesItem) {
		this.givenNames.add(givenNamesItem);
		return this;
	}

	/**
	 * Nombres de la persona, como por ejemplo Diego, Pablo
	 * 
	 * @return givenNames
	 **/
	@ApiModelProperty(value = "Nombres de la persona, como por ejemplo Diego, Pablo")
	public List<String> getGivenNames() {
		return givenNames;
	}

	public void setGivenNames(List<String> givenNames) {
		this.givenNames = givenNames;
	}

	public Person surnames(List<String> surnames) {
		this.surnames = surnames;
		return this;
	}

	public Person addSurnamesItem(String surnamesItem) {
		this.surnames.add(surnamesItem);
		return this;
	}

	/**
	 * Apellidos de la persona, como por ejemplo Mansilla, Cendra
	 * 
	 * @return surnames
	 **/
	@ApiModelProperty(value = "Apellidos de la persona, como por ejemplo Mansilla, Cendra")
	public List<String> getSurnames() {
		return surnames;
	}

	public void setSurnames(List<String> surnames) {
		this.surnames = surnames;
	}

	public Person gender(PersonGender gender) {
		this.gender = gender;
		return this;
	}

	/**
	 * Get gender
	 * 
	 * @return gender
	 **/
	@ApiModelProperty(value = "")
	public PersonGender getGender() {
		return gender;
	}

	public void setGender(PersonGender gender) {
		this.gender = gender;
	}

	public Person birth(PersonBirth birth) {
		this.birth = birth;
		return this;
	}

	/**
	 * Get birth
	 * 
	 * @return birth
	 **/
	@ApiModelProperty(value = "")
	public PersonBirth getBirth() {
		return birth;
	}

	public void setBirth(PersonBirth birth) {
		this.birth = birth;
	}

	public Person nationalities(Nationalities nationalities) {
		this.nationalities = nationalities;
		return this;
	}

	/**
	 * Get nationalities
	 * 
	 * @return nationalities
	 **/
	@ApiModelProperty(value = "")
	public Nationalities getNationalities() {
		return nationalities;
	}

	public void setNationalities(Nationalities nationalities) {
		this.nationalities = nationalities;
	}

	public Person identityDocuments(IdentityDocuments identityDocuments) {
		this.identityDocuments = identityDocuments;
		return this;
	}

	/**
	 * Get identityDocuments
	 * 
	 * @return identityDocuments
	 **/
	@ApiModelProperty(value = "")
	public IdentityDocuments getIdentityDocuments() {
		return identityDocuments;
	}

	public void setIdentityDocuments(IdentityDocuments identityDocuments) {
		this.identityDocuments = identityDocuments;
	}

	public Person communicationOptions(
			CommunicationOptions communicationOptions) {
		this.communicationOptions = communicationOptions;
		return this;
	}

	/**
	 * Get communicationOptions
	 * 
	 * @return communicationOptions
	 **/
	@ApiModelProperty(value = "")
	public CommunicationOptions getCommunicationOptions() {
		return communicationOptions;
	}

	public void setCommunicationOptions(
			CommunicationOptions communicationOptions) {
		this.communicationOptions = communicationOptions;
	}

	public Person healthData(PersonHealthData healthData) {
		this.healthData = healthData;
		return this;
	}

	/**
	 * Get healthData
	 * 
	 * @return healthData
	 **/
	@ApiModelProperty(value = "")
	public PersonHealthData getHealthData() {
		return healthData;
	}

	public void setHealthData(PersonHealthData healthData) {
		this.healthData = healthData;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Person person = (Person) o;
		return Objects.equals(this.id, person.id)
				&& Objects.equals(this.erased, person.erased)
				&& Objects.equals(this.urlPhoto, person.urlPhoto)
				&& Objects.equals(this.givenNames, person.givenNames)
				&& Objects.equals(this.surnames, person.surnames)
				&& Objects.equals(this.gender, person.gender)
				&& Objects.equals(this.birth, person.birth)
				&& Objects.equals(this.nationalities, person.nationalities)
				&& Objects.equals(this.identityDocuments,
						person.identityDocuments)
				&& Objects.equals(this.communicationOptions,
						person.communicationOptions)
				&& Objects.equals(this.healthData, person.healthData);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, erased, urlPhoto, givenNames, surnames, gender,
				birth, nationalities, identityDocuments, communicationOptions,
				healthData);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Person {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    erased: ").append(toIndentedString(erased)).append("\n");
		sb.append("    urlPhoto: ").append(toIndentedString(urlPhoto))
				.append("\n");
		sb.append("    givenNames: ").append(toIndentedString(givenNames))
				.append("\n");
		sb.append("    surnames: ").append(toIndentedString(surnames))
				.append("\n");
		sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
		sb.append("    birth: ").append(toIndentedString(birth)).append("\n");
		sb.append("    nationalities: ")
				.append(toIndentedString(nationalities)).append("\n");
		sb.append("    identityDocuments: ")
				.append(toIndentedString(identityDocuments)).append("\n");
		sb.append("    communicationOptions: ")
				.append(toIndentedString(communicationOptions)).append("\n");
		sb.append("    healthData: ").append(toIndentedString(healthData))
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
