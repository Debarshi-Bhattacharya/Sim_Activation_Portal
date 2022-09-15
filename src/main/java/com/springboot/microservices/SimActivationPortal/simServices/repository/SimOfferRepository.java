package com.springboot.microservices.SimActivationPortal.simServices.repository;

import com.springboot.microservices.SimActivationPortal.simServices.entity.SimDetails;
import com.springboot.microservices.SimActivationPortal.simServices.entity.SimOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SimOfferRepository extends JpaRepository<SimOffers, Integer> {

    @Query("select u from SimOffers u where u.simId = ?1")
    SimDetails findById(Long id);

}
