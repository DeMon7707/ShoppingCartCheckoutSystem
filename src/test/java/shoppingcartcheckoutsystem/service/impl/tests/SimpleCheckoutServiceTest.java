package shoppingcartcheckoutsystem.service.impl.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import shoppingcartcheckoutsystem.repository.ShopItemRepository;
import shoppingcartcheckoutsystem.service.CheckoutService;
import shoppingcartcheckoutsystem.service.impl.SimpleCheckoutService;

@ExtendWith(MockitoExtension.class)
public class SimpleCheckoutServiceTest {

	@Mock
	private static ShopItemRepository shopItemRepository;
	
	@InjectMocks
	private static CheckoutService checkoutService;
	
	@BeforeAll
	public static void setUp() throws Exception {
		shopItemRepository = new ShopItemRepository();
		checkoutService = new SimpleCheckoutService();
	}
	
	@Test
	public void testCalculateTotal() throws Exception {
		when(shopItemRepository.getShopItemPrice("apple")).thenReturn(MockData.getShopItemPrice("apple"));
		when(shopItemRepository.getShopItemPrice("orange")).thenReturn(MockData.getShopItemPrice("orange"));
		BigDecimal total = checkoutService.calculateTotal(MockData.getMapOfItems(Arrays.asList("Apple", "Apple",
				"Orange", "Apple")));
		assertEquals(new BigDecimal("2.05").setScale(2, RoundingMode.CEILING),
				total);
	}
	
	@Test
	public void testCalculateTotalCaseSensitive() throws Exception {
		when(shopItemRepository.getShopItemPrice("apple")).thenReturn(MockData.getShopItemPrice("apple"));
		when(shopItemRepository.getShopItemPrice("orange")).thenReturn(MockData.getShopItemPrice("orange"));
		BigDecimal total = checkoutService.calculateTotal(MockData.getMapOfItems(Arrays.asList("Apple", "apple",
				"orange", "APPLE")));

		assertEquals(new BigDecimal("2.05").setScale(2, RoundingMode.CEILING),
				total);
	}
	
	@Test
	public void testCalculateTotalNoItems() throws Exception {
		BigDecimal total = checkoutService.calculateTotal(MockData.getMapOfItems(Arrays.asList()));

		assertEquals(new BigDecimal("0.00").setScale(2, RoundingMode.CEILING),
				total);
	}
	
}
