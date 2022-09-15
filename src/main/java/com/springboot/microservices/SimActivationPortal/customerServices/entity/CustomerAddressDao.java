package com.springboot.microservices.SimActivationPortal.customerServices.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class CustomerAddressDao {

	@Id
	private int addressId;

	@Length(max=25,message="Address should be maximum of 25 characters")
	private String address;

	@Pattern(regexp="^[A-Za-z\s]*$",message="City/State should not contain any special characters except space")
	private String city;

	@Min(100000)
	@Max(999999)
	private Integer pincode;

	@Pattern(regexp="^[A-Za-z\s]*$",message="City/State should not contain any special characters except space")
	private String state;

	public CustomerAddressDao() {

	}

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public CustomerAddressDao(int addressId, String address, String city, int pincode, String state) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}
	
	

 }
