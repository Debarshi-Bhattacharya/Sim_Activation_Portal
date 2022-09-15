package com.springboot.microservices.SimActivationPortal.simServices.repository;

import com.springboot.microservices.SimActivationPortal.simServices.entity.SimDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface SimDetailsRepository extends JpaRepository<SimDetails, Integer> {

    @Query("select u from SimDetails u where u.simId = ?1")
    SimDetails findById(Long id);

    @Modifying
    @Transactional
    @Query("update SimDetails u set u.simStatus = ?2 where u.simId = ?1")
    void activateSim(Integer simId, String active);

    @Query("select u from SimDetails u where u.simNumber = ?1 and u.serviceNumber = ?2")
    Optional<SimDetails> checkForBoth(String simNumber, String serviceNumber);
}
