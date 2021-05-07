package com.mam.dsvendas.dto;

import java.io.Serializable;

import com.mam.dsvendas.entities.Seller;

public class SaleSumDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String sellerName;
	private Double sum;
	
	
	public SaleSumDTO() {
	}
	
	public SaleSumDTO(Seller seller, Double sum) {
		this.sellerName = seller.getName();
		this.sum = sum;
	}
	
	
	public String getSellerName() {
		return sellerName;
	}
	
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	public Double getSum() {
		return sum;
	}
	
	public void setSum(Double sum) {
		this.sum = sum;
	}
	
	
	
	
	
	

}










/*
 Lista de Objetos:
 [
 	{
 		"sellerName": "Anakin",
 		"sum": 477138.0
 	}
 	{
 		"sellerName": "Barry Allen",
 		"sum": 499928.0
 	}
 ]  
  
 */
