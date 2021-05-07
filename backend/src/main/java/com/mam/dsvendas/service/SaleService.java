package com.mam.dsvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mam.dsvendas.dto.SaleDTO;
import com.mam.dsvendas.entities.Sale;
import com.mam.dsvendas.repositories.SaleRepository;
import com.mam.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	//buscar todos do repository por paginação
	@Autowired
	private SaleRepository repository;
	
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll(); // <-- busca os vendedores e deixa na memória
		
		Page<Sale> result = repository.findAll(pageable);
		
		return result.map(x -> new SaleDTO(x));
	}
	
	
	


}























