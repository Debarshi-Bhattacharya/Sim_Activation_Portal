package com.springboot.microservices.SimActivationPortal.customerServices.repository;

import com.springboot.microservices.SimActivationPortal.customerServices.entity.CustomerAddressDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddressDao,Integer> {

	public Optional<CustomerAddressDao> findById(Integer id);

	@Modifying
	@Query("update CustomerAddress u set u.address = ?1, u.pincode = ?2, u.state = ?3, u.city = ?4 where u.addressId = ?5")
	void update(String address, Integer pincode, String state, String city, Integer id);
}
