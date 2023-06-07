package com.adjecti.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjecti.invoice.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
