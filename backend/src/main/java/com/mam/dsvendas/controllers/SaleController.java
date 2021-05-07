package com.mam.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mam.dsvendas.dto.SaleDTO;
import com.mam.dsvendas.dto.SaleSuccessDTO;
import com.mam.dsvendas.dto.SaleSumDTO;
import com.mam.dsvendas.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	
	//controller da paginação
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findall(Pageable pageable) {
		Page<SaleDTO> list = service.findAll(pageable);
		
		return ResponseEntity.ok(list);
	}
	
	
	//controller do amount por vendedor
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> list = service.amountGroupedBySeller();
		
		return ResponseEntity.ok(list);
	}
	
	
	//controller das vendas com sucesso por vendedor
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
		List<SaleSuccessDTO> list = service.successGroupedBySeller();
		
		return ResponseEntity.ok(list);
	}
	
	

}











