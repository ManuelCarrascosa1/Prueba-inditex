package com.example.demo.domain.repositories;

import java.util.List;

import com.example.demo.domain.aggregates.Price;

public interface PriceRepository {
	
	public List<Price> findAll();

}
