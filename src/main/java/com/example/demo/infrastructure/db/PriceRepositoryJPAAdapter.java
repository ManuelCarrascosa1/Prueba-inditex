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

Amount amount = new Amount(1.1);	
Currency currency;
	@PostConstruct
	public void init() {
		priceRepositoryJPA.saveAll(
				Arrays.asList(
						new PriceJPA(1,"1",LocalDateTime.parse("2020-06-14-00.00.00"),LocalDateTime.parse("2020-12-31-23.59.59"),"1","35455",0,35.5,"EUR")
						/*new Price(2,1, LocalDateTime.parse("2020-06-14T15:00:00.000"),LocalDateTime.parse("2020-06-14T18:30:00.000"),2,35455,1,25.45,"EUR",LocalDateTime.parse("2020-05-26T15:38:22.000"),"user1"),
						new Price(3,1, LocalDateTime.parse("2020-06-15T00:00:00.000"),LocalDateTime.parse("2020-06-15T11:00:00.000"),3,35455,1,30.5,"EUR",LocalDateTime.parse("2020-05-26T15:39:22.000"),"user1"),
						new Price(4,1, LocalDateTime.parse("2020-06-15T16:00:00.000"),LocalDateTime.parse("2020-12-31T23:59:59.000"),1,35455,1,38.95,"EUR",LocalDateTime.parse("2020-06-02T10:14:00.000"),"user1")*/	
						)
				);
		
	}
}
