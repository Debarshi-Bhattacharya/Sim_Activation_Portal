package com.springboot.microservices.SimActivationPortal.customerServices.repository;

import com.springboot.microservices.SimActivationPortal.customerServices.entity.CustomerIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerIdentityRepository extends JpaRepository<CustomerIdentity,String > {

    @Query("select c from CustomerIdentity c where c.dateOfbirth=?1 and c.emailAddress=?2")
    public Optional<CustomerIdentity> findByDateOfBirthAndEmail(String dateOfBirth, String email);

    @Query("select c from CustomerIdentity c where c.firstName=?1 and c.lastName=?2")
    public Optional<CustomerIdentity> findByFirstNameLastName(String firstName, String lastName);

    @Query("select c from CustomerIdentity c where c.emailAddress=?1")
    public Optional<CustomerIdentity> findByMail(String emailAddress);

    @Query("select c from CustomerIdentity c where c.uniqueIdNumber=?1")
    public Optional<CustomerIdentity> findById(String id);


}
