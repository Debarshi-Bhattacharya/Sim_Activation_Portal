package com.springboot.microservices.SimActivationPortal.simServices.service;

import com.springboot.microservices.SimActivationPortal.simServices.dto.SimDetailsDTO;
import com.springboot.microservices.SimActivationPortal.simServices.entity.SimDetails;
import com.springboot.microservices.SimActivationPortal.simServices.entity.SimOffers;
import com.springboot.microservices.SimActivationPortal.simServices.repository.SimDetailsRepository;
import com.springboot.microservices.SimActivationPortal.simServices.repository.SimOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Optional;

@Service
public class SimServiceimpl implements SimService {

	
	@Autowired
	private SimDetailsRepository simRepository;

	@Autowired
	private SimOfferRepository simOfferRepository;

	@Override
	public SimDetails savedetails(SimDetails ob) {
		return simRepository.save(ob);
	}

	@Override
	public StringBuilder getOffersByValidation(SimDetailsDTO dto) throws IllegalAccessException {

		Optional<SimDetails> optSimCardDetails = simRepository.checkForBoth(dto.getSimNumber(), dto.getServiceNumber());

		if(optSimCardDetails.isEmpty()) {
			return new StringBuilder("Invalid details, please check again SIM number/Service number!!");
		}
		Optional<SimOffers> simOffers = simOfferRepository.findById(optSimCardDetails.get().getSimId());
		StringBuilder result = new StringBuilder();
		result.append("OFFERS - ").append(System.lineSeparator());
		for (Field field: simOffers.get().getClass().getDeclaredFields()){
			field.setAccessible(true);
			Object value = field.get(simOffers.get());
			if(!field.getName().equals("simId") && !field.getName().equals("offerId")) {
				result.append(field.getName()).append(" ").append(value).append("+");
			}
		}
		result = new StringBuilder(result.substring(0, result.length() - 1));
		if(Objects.equals(optSimCardDetails.get().getSimStatus(), "active")){
			return new StringBuilder("SIM already active");
		}
		return result;

	}
	/*
	@Override
	public List<SimDetails> getObject(Long n1, Long n2) {
		repo.findByserviceNumberAndsimNumber(n1, n2);
		return null;
	}
	*/
//	@Override
//	public CustomerIdentity savedetails1(CustomerIdentity ol) {
//		// TODO Auto-generated method stub
//		return repo1.save(ol);
//	}
	

}
