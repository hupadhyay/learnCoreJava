package in.himtech.java.mock;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class PortfolioTest {

	private Portfolio portfolio;
	private StockService stockService;
	
	@Before
	public void setup() {
		portfolio = new Portfolio();
		stockService = mock(StockService.class);	
		
		portfolio.setStockService(stockService);
	}
	
	@Test
	public void testGetMarketValue() {
		Stock tcsStock = new Stock("T321", "TCS", 25);
		Stock hclStock = new Stock("H303", "HCL", 10);
		
		List<Stock> listStock = new ArrayList<>();
		listStock.add(tcsStock);
		listStock.add(hclStock);
		
		portfolio.setStocks(listStock);
		
		when(stockService.getPrice(tcsStock)).thenReturn(50.0);	
		when(stockService.getPrice(hclStock)).thenReturn(30.0);
		
		double mktValue = portfolio.getMarketValue();
		
		Assert.assertEquals(1550.0,  mktValue);
	}

}
