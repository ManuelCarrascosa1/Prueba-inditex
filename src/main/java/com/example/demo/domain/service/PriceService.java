package com.example.demo.domain.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.aggregates.Price;
import com.example.demo.domain.exception.PriceNotFoundException;
import com.example.demo.domain.repositories.PriceRepository;


public class PriceService {
	
	private PriceRepository priceRepository;
	
	public PriceService(PriceRepository priceRepository) {
		this.priceRepository= priceRepository;
	}
	
	public Price searchprice(LocalDateTime date, String productId, String brandId) throws PriceNotFoundException {
		
		Optional<Price> price= this.priceRepository.findAll().stream()
			.filter(p -> p.getStartDate().isBefore(date) && p.getEndDate().isAfter(date))
			.filter(p -> p.getProductId().equals(productId))
			.filter(p -> p.getBrandId().equals(brandId))
			.max(Comparator.comparingInt(Price::getPriority));
		
		if(price.isPresent()) {
			return price.get();
		}else {
			throw new PriceNotFoundException("Precio no encontrado");
		}
		
		
	}

}
