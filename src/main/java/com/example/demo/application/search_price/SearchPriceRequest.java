package com.example.demo.application.search_price;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchPriceRequest {
	
	private LocalDateTime date ;
	private String productId ;
	private String BrandId ;
	

	
	

}
