package com.example.demo.application.search_price;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchPriceResponse {
	
	
	private  String productId;
	private  String brandId;
	private  String rate;
	private  String dateStart;
	private  String dateEnd;
	private  String price;
	
	
	

	}
	
	

