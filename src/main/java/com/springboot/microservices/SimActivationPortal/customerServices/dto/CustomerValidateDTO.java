package com.springboot.microservices.SimActivationPortal.customerServices.dto;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class CustomerValidateDTO {



    @Email(message="Email Address format not specified")
    @NotNull
    private String emailAddress;

    @Length(max=15)
    @NotBlank(message="Firstname/Lastname should be maximum of 15 characters only")
    @NotNull
    @Pattern(regexp = "^[A-z]*$",message = "Firstname/Lastname should be maximum of 15 characters only")
    private String firstName;

    @Length(max=15)
    @NotBlank(message="Firstname/Lastname should be maximum of 15 characters only")
    @NotNull
    @Pattern(regexp = "^[A-z]*$",message = "Firstname/Lastname should be maximum of 15 characters only")
    private String lastName;


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

    public CustomerValidateDTO(@Email(message = "Email Address format not specified") String emailAddress,
                               @Length(max = 15) String firstName, @Length(max = 15) String lastName) {
        super();
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CustomerValidateDTO() {
        super();
    }


}
