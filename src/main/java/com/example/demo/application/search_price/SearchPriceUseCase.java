package com.example.demo.application.search_price;

import com.example.demo.domain.aggregates.Price;
import com.example.demo.domain.exception.PriceNotFoundException;
import com.example.demo.domain.service.PriceService;
import com.example.demo.domain.util.FormatUtil;

public class SearchPriceUseCase {

	private PriceService priceService;

	public SearchPriceUseCase(PriceService priceService) {
		this.priceService = priceService;
	}

	public SearchPriceResponse execute(SearchPriceRequest request) throws PriceNotFoundException {

		Price price = this.priceService.searchprice(request.getDate(), request.getProductId(), request.getBrandId());

		return SearchPriceResponse.builder().productId(price.getProductId()).brandId(price.getBrandId())
				.dateStart(FormatUtil.toFormat(price.getStartDate())).dateEnd(FormatUtil.toFormat(price.getEndDate()))
				.price(price.getFinalPrice()).rate(price.getPriceList().toString()).build();

	}

}
