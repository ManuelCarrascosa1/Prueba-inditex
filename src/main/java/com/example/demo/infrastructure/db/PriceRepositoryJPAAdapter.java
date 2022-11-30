package com.example.demo.infrastructure.db;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.application.mappers.PriceMapper;
import com.example.demo.domain.aggregates.Price;
import com.example.demo.domain.repositories.PriceRepository;
import com.example.demo.domain.vos.Amount;
import com.example.demo.domain.vos.Currency;

@Repository
public class PriceRepositoryJPAAdapter implements PriceRepository {

	@Autowired
	private PriceRepositoryJPA priceRepositoryJPA;
	
	@Override
	public List<Price> findAll() {
		
		return this.priceRepositoryJPA.findAll()
				.stream().map(PriceMapper::toModel).collect(Collectors.toList());
	}

}
