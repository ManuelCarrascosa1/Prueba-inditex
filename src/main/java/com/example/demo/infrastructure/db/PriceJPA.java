package com.example.demo.infrastructure.db;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.domain.vos.Currency;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PRICES")
public class PriceJPA {
	
	

	public PriceJPA(int priceId, String brandId, LocalDateTime startDate, LocalDateTime endDate, String priceList,
			String productId, Integer proirity, Double price, String currency) {
		super();
		this.priceId = priceId;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.proirity = proirity;
		this.price = price;
		this.currency = currency;
	}


	@Id
	@Column(name="PRICE_ID")
	private int priceId;
	
	
	@Column(name = "BRAND_ID")
	private String brandId;
	
	
	@Column(name = "START_DATE")
	private LocalDateTime startDate;
	
	
	@Column(name = "END_DATE")
	private LocalDateTime endDate;
	
	
	@Column(name = "PRICE_LIST")
	private String priceList;
	

	@Column(name = "PRODUCT_ID")
	private String productId;
	
	
	@Column(name = "PRIORITY")
	private Integer proirity;
	
	
	@Column(name = "PRICE")
	private Double price;
	
	
	@Column(name = "CURR")
	private String currency;



	

}
