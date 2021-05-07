package com.mam.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mam.dsvendas.dto.SaleDTO;
import com.mam.dsvendas.dto.SaleSuccessDTO;
import com.mam.dsvendas.dto.SaleSumDTO;
import com.mam.dsvendas.entities.Sale;
import com.mam.dsvendas.repositories.SaleRepository;
import com.mam.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	
	@Autowired
	private SaleRepository repository;
	
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
	//buscar todos do repository por paginação
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll(); // <-- busca os vendedores e deixa na memória
		
		Page<Sale> result = repository.findAll(pageable);
		
		return result.map(x -> new SaleDTO(x));
	}
	
	
	//busca por total vendas, por vendedor
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		
		return repository.amountGroupedBySeller();
	}
	
	
	//busca por vendas realizadas com sucesso
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		
		return repository.successGroupedBySeller();
	}
	
	
	


}























