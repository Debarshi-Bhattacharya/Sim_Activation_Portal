package com.springboot.microservices.SimActivationPortal.customerServices.controller;

import com.springboot.microservices.SimActivationPortal.customerServices.dto.CustomerBasicDetailDTO;
import com.springboot.microservices.SimActivationPortal.customerServices.dto.CustomerDTO;
import com.springboot.microservices.SimActivationPortal.customerServices.dto.CustomerValidateDTO;
import com.springboot.microservices.SimActivationPortal.customerServices.entity.CustomerAddress;
import com.springboot.microservices.SimActivationPortal.customerServices.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/validateBasicDetails")
    public ResponseEntity<Object> validateDetails(@Valid @RequestBody CustomerBasicDetailDTO dto ) throws Exception {

        return ResponseEntity.ok(customerService.validate(dto));

    }
    @PostMapping("/validateDetails")
    public ResponseEntity<Object> validateDetails(@RequestBody @Valid CustomerValidateDTO dto ) throws Exception{

        return ResponseEntity.ok(customerService.validate(dto));

    }
    @PutMapping("/addAddress")
    public ResponseEntity<Object> addAddress(@RequestBody @Valid CustomerAddress address) throws Exception{

        return ResponseEntity.ok(customerService.addAddress(address));
    }

    @PostMapping(value = "/customerValidation",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> customerVlidation(@RequestBody @Valid CustomerDTO dto ) throws Exception{
        String id = customerService.validateCustomerIdentity(dto);
        if(id.length()<2)
        {
            System.out.println(id);
            String result = this.restTemplate.getForObject("http://contact-service/contact/user/" + Integer.valueOf(id), String.class);

        }
        else {
            return ResponseEntity.ok(customerService.validateCustomerIdentity(dto));
        }
        return null;
    }
}
