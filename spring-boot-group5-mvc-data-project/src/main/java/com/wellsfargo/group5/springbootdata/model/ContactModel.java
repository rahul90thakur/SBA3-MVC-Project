package com.wellsfargo.group5.springbootdata.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ContactModel implements Comparable<ContactModel>{

	@NotNull(message="Contact ID is mandate")
	@NotBlank(message="Contact ID is mandate")
	@Min(value=1, message="Contact ID can not be negative")
	private Long contactId;
	
	@NotNull(message="First name is mandate")
	@NotBlank(message="First Name is mandate")
	private String firstName;
	
	@NotNull(message="Last name is mandate")
	@NotBlank(message="Last Name is mandate")
	private String lastName;
	

	private ContactDetailsModel contactDetails;

	private AddressGroupModel adbGroup;

	public ContactModel() {
		
	}
	
	public ContactModel(Long contactId, String firstName, String lastName, ContactDetailsModel contactDetails,
			AddressGroupModel adbGroup) {
		super();
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactDetails = contactDetails;
		this.adbGroup = adbGroup;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNAme() {
		return lastName;
	}

	public void setLastNAme(String lastName) {
		this.lastName = lastName;
	}

	public ContactDetailsModel getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetailsModel contactDetails) {
		this.contactDetails = contactDetails;
	}

	public AddressGroupModel getAdbGroup() {
		return adbGroup;
	}

	public void setAdbGroup(AddressGroupModel adbGroup) {
		this.adbGroup = adbGroup;
	}

	@Override
	public int compareTo(ContactModel o) {
		return this.contactId.compareTo(o.contactId);
	}
	
	@Override
	public int hashCode() {	
		return Objects.hashCode(this.contactId);
	}
	
	@Override
	public boolean equals(Object obj) {	
		return Objects.equals(this, obj);
	}
}
