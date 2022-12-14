package com.springboot.microservices.SimActivationPortal.simServices.controller;

import com.springboot.microservices.SimActivationPortal.simServices.dto.SimDetailsDTO;
import com.springboot.microservices.SimActivationPortal.simServices.service.SimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SimActivationController {
    @Autowired
    private SimService simService;

    @PostMapping(value  = "/simOffers",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> validateAndGetOffers(@RequestBody @Valid SimDetailsDTO dto) throws IllegalAccessException {

        return ResponseEntity.ok(simService.getOffersByValidation(dto));

    }
}
