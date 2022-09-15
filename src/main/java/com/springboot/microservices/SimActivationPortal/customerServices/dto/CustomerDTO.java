package com.springboot.microservices.SimActivationPortal.customerServices.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDTO {
    @Length(max=16,message = "Id Should be 16 digit")
    private String uniqueIdNumber;


    @NotNull
    @Pattern(regexp = "(\\d{4})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])", message = "Invalid BirthDate")
    private String dateOfBirth;

    @Email(message="Email Address format not specified")
    private String emailAddress;

    @Length(max=15)
    @NotNull
    private String firstName;

    @Length(max=15)
    @NotNull
    private String lastName;

    @NotNull
    private Integer simId;

//	@OneToOne
//	@JoinColumn(name="address_id")
//	private CustomerAddress address;
//
//	@OneToOne
//	@JoinColumn(name="sim_Id")
//	private SimDetails details;

    public String getUniqueIdNumber() {
        return uniqueIdNumber;
    }

    public void setUniqueIdNumber(String uniqueIdNumber) {
        this.uniqueIdNumber = uniqueIdNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
//
//	public CustomerAddress getAddress() {
//		return address;
//	}
//
//	public void setAddress(CustomerAddress address) {
//		this.address = address;
//	}
//
//	public SimDetails getDetails() {
//		return details;
//	}
//
//	public void setDetails(SimDetails details) {
//		this.details = details;
//	}

    public void setSimId(Integer simId){
        this.simId = simId;
    }
    public int getSimId() {
        return simId;
    }
}
