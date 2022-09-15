package com.springboot.microservices.SimActivationPortal.customerServices.service;

import com.springboot.microservices.SimActivationPortal.customerServices.dto.CustomerBasicDetailDTO;
import com.springboot.microservices.SimActivationPortal.customerServices.dto.CustomerDTO;
import com.springboot.microservices.SimActivationPortal.customerServices.dto.CustomerValidateDTO;
import com.springboot.microservices.SimActivationPortal.customerServices.entity.CustomerAddress;
import com.springboot.microservices.SimActivationPortal.customerServices.entity.CustomerIdentity;
import com.springboot.microservices.SimActivationPortal.customerServices.repository.CustomerAddressRepository;
import com.springboot.microservices.SimActivationPortal.customerServices.repository.CustomerIdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService {

    @Autowired
    private CustomerIdentityRepository customerIdentityRepo;

    @Autowired
    private CustomerAddressRepository addressRepository;


    public String validate(CustomerBasicDetailDTO dto) throws Exception {


        String email = dto.getEmailAddress();


        String date = String.valueOf(dto.getDateOfbirth());


        Optional<CustomerIdentity> optCustomerIdentiy = customerIdentityRepo.findByDateOfBirthAndEmail(date, email);

        if (optCustomerIdentiy.isEmpty()) {
            return "No request placed for you";
        }
        return "Success";

    }

    public String validate(CustomerValidateDTO dto) throws Exception {

        String firstName = dto.getFirstName();
        String lastName = dto.getLastName();


        String email = dto.getEmailAddress();


        Optional<CustomerIdentity> optCustomerIdentiy = customerIdentityRepo.findByFirstNameLastName(firstName, lastName);
        Optional<CustomerIdentity> optCustomerIdentiy1 = customerIdentityRepo.findByMail(email);

        if (optCustomerIdentiy.isEmpty()) {
            return "No customer found for the provided details";
        }

        if (optCustomerIdentiy1.isEmpty()) {
            return "Invalid email details!";
        }

        return "Success";

    }

    public String validateCustomerIdentity(CustomerDTO dto) throws Exception {

        Optional<CustomerIdentity> customerOptional = customerIdentityRepo.findById(String.valueOf(dto.getUniqueIdNumber()));

        if (customerOptional.isEmpty()) {
            return "Invalid details";
        }
        CustomerIdentity customerFromRecord = customerOptional.get();
        if (customerFromRecord.getFirstName().equalsIgnoreCase(dto.getFirstName())
                && customerFromRecord.getLastName().equalsIgnoreCase(dto.getLastName())
                && customerFromRecord.getDateOfbirth().equals(dto.getDateOfBirth())) {
            return String.valueOf(dto.getSimId());
//            Optional<SimDetails> availableSimCards = simRepository.findById(dto.getSimId());
//
//            if(Objects.equals(availableSimCards.get().getSimStatus(), "active"))
//                return "Sim already active";
//
//            if(Objects.equals(availableSimCards.get().getSimStatus(), "inactive")) {
//                simRepository.activateSim(availableSimCards.get().getSimId(),"active");
//                return "Sim activated successfully";
//            }
        }
        return "DETAILS NOT VALID";
    }
    public String addAddress(CustomerAddress dto) throws Exception {


        Optional<CustomerAddress> optAddress = addressRepository.findById(dto.getAddressId());
        if(optAddress.isPresent()) {
            addressRepository.update(dto.getAddress(),dto.getPincode(),dto.getState(),dto.getCity(), dto.getAddressId());
            return "Address Updated";
        }

        addressRepository.save(dto);

        return "new Address recorded successfully";


    }
}
