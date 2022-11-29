package com.example.demo.application.mappers;

import com.example.demo.domain.aggregates.Price;
import com.example.demo.domain.vos.Amount;
import com.example.demo.domain.vos.Currency;
import com.example.demo.infrastructure.db.PriceJPA;



public class PriceMapper {
	
	private PriceMapper() {
		
	}
	
	public static Price toModel (PriceJPA priceJPA) {
	
		return Price.builder()
				.amount(new Amount(priceJPA.getPrice()))
				.brandId(priceJPA.getBrandId())
				.currency(Currency.valueOf(priceJPA.getCurrency()))
				.endDate( priceJPA.getEndDate())
				.priceList(Integer.valueOf(priceJPA.getPriceList()))
				.priority(priceJPA.getProirity())
				.productId(priceJPA.getProductId())
				.startDate(priceJPA.getStartDate())
				.build();
	}

}
