package com.example.demo.infrastructure.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.search_price.SearchPriceRequest;
import com.example.demo.application.search_price.SearchPriceResponse;
import com.example.demo.application.search_price.SearchPriceUseCase;

import com.example.demo.domain.exception.PriceNotFoundException;
import com.example.demo.domain.util.FormatUtil;
import com.example.demo.infrastructure.db.PriceRepositoryJPA;


@RestController
public class PriceController {
	
	@Autowired
	private SearchPriceUseCase useCase;
	
	@Autowired
	private PriceRepositoryJPA repository;
	
	
	@GetMapping("/price/search")
	public ResponseEntity<SearchPriceResponse> searchPrice(
			@RequestParam(required = true) String date,
			@RequestParam(required = true) String idProduct,
			@RequestParam(required = true) String idBrand
			
			) throws PriceNotFoundException{
		
		SearchPriceRequest request = SearchPriceRequest.builder()
				.date(FormatUtil.dateParse(date))
				.productId(idProduct)
				.BrandId(idBrand)
				.build();
		
		SearchPriceResponse response = useCase.execute(request);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	};
	
	
	
		
	
	


}
