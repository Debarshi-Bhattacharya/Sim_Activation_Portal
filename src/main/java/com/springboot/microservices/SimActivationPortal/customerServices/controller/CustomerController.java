package com.springboot.microservices.SimActivationPortal.customerServices.controller;

import com.springboot.microservices.SimActivationPortal.customerServices.dto.CustomerBasicDetailDTO;
import com.springboot.microservices.SimActivationPortal.customerServices.dto.CustomerDTO;
import com.springboot.microservices.SimActivationPortal.customerServices.dto.CustomerValidateDTO;
import com.springboot.microservices.SimActivationPortal.customerServices.entity.CustomerAddressDao;
import com.springboot.microservices.SimActivationPortal.customerServices.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/validateBasicDetails")
    public ResponseEntity<Object> validateDetails(@Valid @RequestBody CustomerBasicDetailDTO dto ) throws Exception {

        return ResponseEntity.ok(customerService.validate(dto));

    }
    @PostMapping("/validateDetails")
    public ResponseEntity<Object> validateDetails(@RequestBody @Valid CustomerValidateDTO dto ) throws Exception{

        return ResponseEntity.ok(customerService.validate(dto));

    }
    @PutMapping("/addAddress")
    public ResponseEntity<Object> addAddress(@RequestBody @Valid CustomerAddressDao address) throws Exception{

        return ResponseEntity.ok(customerService.addAddress(address));
    }

    @PostMapping(value = "/customerValidation",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> customerVlidation(@RequestBody @Valid CustomerDTO dto ) throws Exception{

        return ResponseEntity.ok(customerService.validateCustomerIdentity(dto));

    }
}
