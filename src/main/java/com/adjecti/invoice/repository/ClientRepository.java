package com.adjecti.invoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adjecti.invoice.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	@Query(value = "SELECT * FROM client where enabled=0", nativeQuery = true)
	public List<Client> findByEnabled();
		
}
