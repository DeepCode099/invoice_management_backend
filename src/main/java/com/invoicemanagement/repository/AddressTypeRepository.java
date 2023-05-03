package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.AddressType;

public interface AddressTypeRepository extends JpaRepository<AddressType, Long> { 

}
