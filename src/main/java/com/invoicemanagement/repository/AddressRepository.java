package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
