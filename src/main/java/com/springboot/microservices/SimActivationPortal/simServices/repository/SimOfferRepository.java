package com.springboot.microservices.SimActivationPortal.simServices.repository;

import com.springboot.microservices.SimActivationPortal.simServices.entity.SimDetailsDao;
import com.springboot.microservices.SimActivationPortal.simServices.entity.SimOffersDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SimOfferRepository extends JpaRepository<SimOffersDao, Integer> {

    @Query("select u from SimOffers u where u.simId = ?1")
    SimDetailsDao findById(Long id);

}
