package com.invoicemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.invoicemanagement.model.AddressType;

public interface AddressTypeRepository extends JpaRepository<AddressType, Long> { 
	
	@Query(value = "select * from address_type where enabled = 0", nativeQuery = true)
	public List<AddressType> findByEnabled();

}
