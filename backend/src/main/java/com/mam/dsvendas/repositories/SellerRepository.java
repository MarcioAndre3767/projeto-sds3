package com.mam.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mam.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{
	
}