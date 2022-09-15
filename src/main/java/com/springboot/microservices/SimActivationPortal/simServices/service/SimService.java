package com.springboot.microservices.SimActivationPortal.simServices.service;

import com.springboot.microservices.SimActivationPortal.simServices.dto.SimDetailsDTO;
import com.springboot.microservices.SimActivationPortal.simServices.entity.SimDetails;
import org.springframework.stereotype.Service;

@Service
public interface SimService {
	
      SimDetails savedetails(SimDetails ob);

      StringBuilder getOffersByValidation(SimDetailsDTO dto) throws IllegalAccessException;
}
