package com.adjecti.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjecti.invoice.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
