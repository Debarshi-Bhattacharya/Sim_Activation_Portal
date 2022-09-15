package com.springboot.microservices.SimActivationPortal.simServices.service;

import com.springboot.microservices.SimActivationPortal.simServices.dto.SimDetailsDTO;
import com.springboot.microservices.SimActivationPortal.simServices.entity.SimDetailsDao;
import org.springframework.stereotype.Service;

@Service
public interface SimService {
	
      SimDetailsDao savedetails(SimDetailsDao ob);

      StringBuilder getOffersByValidation(SimDetailsDTO dto) throws IllegalAccessException;
}
