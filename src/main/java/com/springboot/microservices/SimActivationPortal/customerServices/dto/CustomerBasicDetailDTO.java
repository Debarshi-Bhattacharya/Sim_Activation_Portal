package com.springboot.microservices.SimActivationPortal.customerServices.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerBasicDetailDTO {



    @Email(message="Email Address format not specified")
    @NotNull
    private String emailAddress;

    @NotNull
    @Pattern(regexp = "(\\d{4})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])", message = "Invalid BirthDate")
    private String dateOfbirth;


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public String getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(String dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public CustomerBasicDetailDTO(@Email(message = "Email Address format not specified") String emailAddress) {
        super();
        this.emailAddress = emailAddress;
    }

    public CustomerBasicDetailDTO() {
        super();
    }
}
