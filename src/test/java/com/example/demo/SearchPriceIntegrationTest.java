package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.example.demo.application.search_price.SearchPriceResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
public class SearchPriceIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	public void shouldWorksFirstcase() {
	ResponseEntity<SearchPriceResponse> res= restTemplate.getForEntity("/price/search?date=2020-06-14-10.00.00&idProduct=35455&idBrand=1", SearchPriceResponse.class);
	
	
	assertTrue(res.getStatusCode().is2xxSuccessful());
	
	SearchPriceResponse response  = res.getBody();
	
	assertEquals("35455", response.getProductId());
	assertEquals("1", response.getBrandId());
	assertEquals("2020-06-14-00.00.00",response.getDateStart());
	assertEquals("2020-12-31-23.59.59",response.getDateEnd());
	assertEquals("1", response.getRate());
	assertEquals("35,50 EUR", response.getPrice());
	
	
	}
	
	@Test
	public void shouldWorksSecondcase() {
	ResponseEntity<SearchPriceResponse> res= restTemplate.getForEntity("/price/search?date=2020-06-14-16.00.00&idProduct=35455&idBrand=1", SearchPriceResponse.class);
	
	
	assertTrue(res.getStatusCode().is2xxSuccessful());
	
	SearchPriceResponse response  = res.getBody();
	
	assertEquals("35455", response.getProductId());
	assertEquals("1", response.getBrandId());
	assertEquals("2020-06-14-15.00.00",response.getDateStart());
	assertEquals("2020-06-14-18.30.00",response.getDateEnd());
	assertEquals("2", response.getRate());
	assertEquals("25,45 EUR", response.getPrice());
	}
	
	@Test
	public void shouldWorksthirdcase() {
	ResponseEntity<SearchPriceResponse> res= restTemplate.getForEntity("/price/search?date=2020-06-14-21.00.00&idProduct=35455&idBrand=1", SearchPriceResponse.class);
	
	
	assertTrue(res.getStatusCode().is2xxSuccessful());
	
	SearchPriceResponse response  = res.getBody();
	assertEquals("35455", response.getProductId());
	assertEquals("1", response.getBrandId());
	assertEquals("2020-06-14-00.00.00",response.getDateStart());
	assertEquals("2020-12-31-23.59.59",response.getDateEnd());
	assertEquals("1", response.getRate());
	assertEquals("35,50 EUR", response.getPrice());
	
	}
	
	@Test
	public void shouldWorksFourcase() {
	ResponseEntity<SearchPriceResponse> res= restTemplate.getForEntity("/price/search?date=2020-06-15-10.00.00&idProduct=35455&idBrand=1", SearchPriceResponse.class);
	
	
	assertTrue(res.getStatusCode().is2xxSuccessful());
	
	SearchPriceResponse response  = res.getBody();
	

	assertEquals("35455", response.getProductId());
	assertEquals("1", response.getBrandId());
	assertEquals("2020-06-15-00.00.00",response.getDateStart());
	assertEquals("2020-06-15-11.00.00",response.getDateEnd());
	assertEquals("3", response.getRate());
	assertEquals("30,50 EUR", response.getPrice());
	
	
	}
	@Test
	public void shouldWorksFivecase() {
	ResponseEntity<SearchPriceResponse> res= restTemplate.getForEntity("/price/search?date=2020-06-16-21.00.00&idProduct=35455&idBrand=1", SearchPriceResponse.class);
	
	
	assertTrue(res.getStatusCode().is2xxSuccessful());
	
	SearchPriceResponse response  = res.getBody();
	
	assertEquals("35455", response.getProductId());
	assertEquals("1", response.getBrandId());
	assertEquals("2020-06-15-16.00.00",response.getDateStart());
	assertEquals("2020-12-31-23.59.59",response.getDateEnd());
	assertEquals("4", response.getRate());
	assertEquals("38,95 EUR", response.getPrice());
	
	}
	
	
	
	
	
	
	

}
