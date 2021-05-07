package com.mam.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mam.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
}