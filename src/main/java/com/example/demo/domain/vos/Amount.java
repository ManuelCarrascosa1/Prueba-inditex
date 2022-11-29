package com.example.demo.domain.vos;

public class Amount {
	
	private Double value;
	
	public Amount(Double amount) {
		if(amount > 0) {
			this.value=amount;
			
		}else {
			throw new IllegalArgumentException("Amount no puede ser negativo");
		}
	}
	
	public Double getValue() {
		return value;
	}

}
