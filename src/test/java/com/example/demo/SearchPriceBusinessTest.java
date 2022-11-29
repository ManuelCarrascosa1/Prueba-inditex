package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import com.example.demo.application.search_price.SearchPriceRequest;
import com.example.demo.application.search_price.SearchPriceResponse;
import com.example.demo.application.search_price.SearchPriceUseCase;
import com.example.demo.domain.aggregates.Price;
import com.example.demo.domain.exception.PriceNotFoundException;
import com.example.demo.domain.repositories.PriceRepository;
import com.example.demo.domain.service.PriceService;
import com.example.demo.domain.util.FormatUtil;
import com.example.demo.domain.vos.Amount;
import com.example.demo.domain.vos.Currency;

public class SearchPriceBusinessTest {

	private final PriceRepository priceRepository = Mockito.mock(PriceRepository.class);
	private final PriceService priceService= new PriceService(priceRepository);
	private final SearchPriceUseCase searchPriceUseCase= new SearchPriceUseCase(priceService);
	
	@Test
	public void shouldSearchPriceFirstCase() throws PriceNotFoundException  {
		
		Mockito.when(((OngoingStubbing) priceRepository.findAll()).thenReturn(this.getPrices()));
		
		SearchPriceRequest request = SearchPriceRequest.builder()
			.date(FormatUtil.dateParse("2020-06-14-10.00.00"))
			.productId("35455")
			.BrandId("1")
			.build();

		SearchPriceResponse response= searchPriceUseCase.execute(request);
		
		assertEquals("35455", response.getProductId());
		assertEquals("1", response.getBrandId());
		assertEquals("2020-06-14-00.00.00",response.getDateStart());
		assertEquals("2020-12-31-23.59.59",response.getDateEnd());
		assertEquals("0", response.getRate());
		assertEquals("35.50 EUR", response.getPrice());
		
	}
	
	@Test
	public void shouldSearchPriceSecondCase() throws PriceNotFoundException  {
		
		Mockito.when(((OngoingStubbing) priceRepository.findAll()).thenReturn(this.getPrices()));
		
		SearchPriceRequest request = SearchPriceRequest.builder()
			.date(FormatUtil.dateParse("2020-06-14-16.00.00"))
			.productId("35455")
			.BrandId("1")
			.build();

		SearchPriceResponse response= searchPriceUseCase.execute(request);
		
		assertEquals("35455", response.getProductId());
		assertEquals("1", response.getBrandId());
		assertEquals("2020-06-14-15.00.00",response.getDateStart());
		assertEquals("2020-06-14-18.30.00",response.getDateEnd());
		assertEquals("1", response.getRate());
		assertEquals("25.45 EUR", response.getPrice());
		
	}
	
	@Test
	public void shouldSearchPricethirdCase() throws PriceNotFoundException  {
		
		Mockito.when(((OngoingStubbing) priceRepository.findAll()).thenReturn(this.getPrices()));
		
		SearchPriceRequest request = SearchPriceRequest.builder()
			.date(FormatUtil.dateParse("2020-06-14-21.00.00"))
			.productId("35455")
			.BrandId("1")
			.build();

		SearchPriceResponse response= searchPriceUseCase.execute(request);
		
		assertEquals("35455", response.getProductId());
		assertEquals("1", response.getBrandId());
		assertEquals("2020-06-14-00.00.00",response.getDateStart());
		assertEquals("2020-12-31-23.59.59",response.getDateEnd());
		assertEquals("2", response.getRate());
		assertEquals("35.50 EUR", response.getPrice());
		
	}
	
	
	@Test
	public void shouldSearchPriceFourthCase() throws PriceNotFoundException  {
		
		Mockito.when(((OngoingStubbing<OngoingStubbing>) priceRepository.findAll()).thenReturn((OngoingStubbing) this.getPrices()));
		
		SearchPriceRequest request = SearchPriceRequest.builder()
			.date(FormatUtil.dateParse("2020-06-15-10.00.00"))
			.productId("35455")
			.BrandId("1")
			.build();

		SearchPriceResponse response= searchPriceUseCase.execute(request);
		
		assertEquals("35455", response.getProductId());
		assertEquals("4", response.getBrandId());
		assertEquals("2020-06-15-00.00.00",response.getDateStart());
		assertEquals("2020-06-15-11.00.00",response.getDateEnd());
		assertEquals("3", response.getRate());
		assertEquals("30.50 EUR", response.getPrice());
		
	}
	
	
	@Test
	public void shouldSearchPriceFiveCase() throws PriceNotFoundException  {
		
		Mockito.when(((OngoingStubbing<OngoingStubbing>) priceRepository.findAll()).thenReturn((OngoingStubbing) this.getPrices()));
		
		SearchPriceRequest request = SearchPriceRequest.builder()
			.date(FormatUtil.dateParse("2020-06-16-21.00.00"))
			.productId("35455")
			.BrandId("1")
			.build();

		SearchPriceResponse response= searchPriceUseCase.execute(request);
		
		assertEquals("35455", response.getProductId());
		assertEquals("4", response.getBrandId());
		assertEquals("2020-06-15-16.00.00",response.getDateStart());
		assertEquals("2020-12-31-23.59.59",response.getDateEnd());
		assertEquals("4", response.getRate());
		assertEquals("38.95 EUR", response.getPrice());
		
	}
	
	private List<Price> getPrices(){
		
		List<Price> listPrices = new ArrayList<>();
		
		listPrices.add(Price.builder().brandId("1").startDate(FormatUtil.dateParse("2020-06-14-10.00.00"))
				.endDate(FormatUtil.dateParse("2020-12-31-23.59.59")).priceList(1)
				.productId("35455").priority(0).amount(new Amount(Double.valueOf(35.50)))
				.currency(Currency.valueOf("EUR")).build());
		
		
		listPrices.add(Price.builder().brandId("1")
				.startDate(FormatUtil.dateParse("2020-06-15-10.00.00"))
				.endDate(FormatUtil.dateParse("2020-06-14-18.30.00")).priceList(2)
				.productId("35455").priority(1).amount(new Amount(Double.valueOf(25.45)))
				.currency(Currency.valueOf("EUR")).build());
		
		
		listPrices.add(Price.builder().brandId("1")
				.startDate(FormatUtil.dateParse("2020-06-15-00.00.00"))
				.endDate(FormatUtil.dateParse("2020-06-15-11.00.00")).priceList(3)
				.productId("35455").priority(1).amount(new Amount(Double.valueOf(30.50)))
				.currency(Currency.valueOf("EUR")).build());
		
		
		listPrices.add(Price.builder().brandId("1")
				.startDate(FormatUtil.dateParse("2020-06-15-16.00.00"))
				.endDate(FormatUtil.dateParse("2020-12-31-23.59.59")).priceList(4)
				.productId("35455").priority(1).amount(new Amount(Double.valueOf(38.95)))
				.currency(Currency.valueOf("EUR")).build());
		
		
		
		return listPrices;
		
	}
	
	
	
}
