package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
