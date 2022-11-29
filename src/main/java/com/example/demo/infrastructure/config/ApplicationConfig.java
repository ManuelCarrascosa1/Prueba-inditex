package com.example.demo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.application.search_price.SearchPriceUseCase;
import com.example.demo.domain.repositories.PriceRepository;
import com.example.demo.domain.service.PriceService;

@Configuration
public class ApplicationConfig {

	@Bean
	public PriceService priceService(PriceRepository priceRepository) {
		return new PriceService(priceRepository);	
		
	}
	@Bean
	public SearchPriceUseCase searchPriceUseCase(PriceService priceService) {
		return new SearchPriceUseCase(priceService);
	}
	
}
