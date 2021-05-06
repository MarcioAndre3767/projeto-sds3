package com.mam.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mam.dsvendas.dto.SellerDTO;
import com.mam.dsvendas.entities.Seller;
import com.mam.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	
	//buscar todos do repository
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){		
		List<Seller> result =  repository.findAll();
		
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
				
	}

}























