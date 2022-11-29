package com.example.demo.domain.vos;

public enum Currency {
	
	
	EUR("EUR");
	
	public final String value;
	
	Currency(String currency) {
		
		this.value=currency;
		
	}
	
	public String getValue() {
		return value;
	}

}
