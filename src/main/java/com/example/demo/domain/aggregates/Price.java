package com.example.demo.domain.aggregates;

import java.time.LocalDateTime;

import com.example.demo.domain.util.FormatUtil;
import com.example.demo.domain.vos.Amount;
import com.example.demo.domain.vos.Currency;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {
	
	private String brandId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private  Integer priceList;
	private String productId;
	private Integer priority;
	private double price;
	private Amount amount;
	private Currency currency;
	
	
	public String getFinalPrice() {
		return FormatUtil.formatDouble(amount.getValue()) + " " + this.currency.getValue();
	}

	public Price(String brandId, LocalDateTime startDate, LocalDateTime endDate, Integer priceList, String productId,
			Integer priority, double price, Amount amount, Currency currency) {
		super();
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.priority = priority;
		this.price=price;
		this.amount = amount;
		this.currency = currency;
	}


	
	

}
