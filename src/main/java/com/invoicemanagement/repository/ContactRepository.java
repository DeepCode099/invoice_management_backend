package com.invoicemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicemanagement.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
