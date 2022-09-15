package com.springboot.microservices.SimActivationPortal.simServices.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SimDetailsDTO {
	
	@NotNull(message="Service Number canot be null")

	@NotBlank(message="Service Number can not be Empty")
	@Pattern(regexp="\\d{10}",message="Service Number must have 10 Digits")
	@Size(min = 10, max = 10,message="Service NUMBER SHOULD HAVE 10 DIGITS")
	private String serviceNumber;
	
	@NotNull(message="SIM NUMBER canot be null")

    @Pattern(regexp="\\d{13}",message="SIM NUMBER must have 13 Digits")
	@Size(min = 13, max = 13,message="SIM NUMBER SHOULD HAVE 13 DIGITS")
	private String simNumber;
	


	
	
//
//	public Set<SimOffers> getOffers() {
//		return offers;
//	}
//
//
//	public void setOffers(Set<SimOffers> offers) {
//		this.offers = offers;
//	}


	public SimDetailsDTO(
			@NotNull(message = "Service Number canot be null") @NotBlank(message = "Service Number can not be Empty") @Pattern(regexp = "\\d{10}", message = "Service Number must have 10 Digits") @Size(min = 10, max = 10, message = "Service NUMBER SHOULD HAVE 10 DIGITS") String serviceNumber,
			@NotNull(message = "SIM NUMBER canot be null") @Pattern(regexp = "\\d{13}", message = "SIM NUMBER must have 13 Digits") @Size(min = 13, max = 13, message = "SIM NUMBER SHOULD HAVE 13 DIGITS") String simNumber) {
		super();
		this.serviceNumber = serviceNumber;
		this.simNumber = simNumber;
	}

	public SimDetailsDTO(){
		
	}




	public String getServiceNumber() {
		return serviceNumber;
	}


	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}


	public String getSimNumber() {
		return simNumber;
	}


	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

}

