package shoppingcartcheckoutsystem.service.impl.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import shoppingcartcheckoutsystem.service.impl.DiscountedCheckoutService;

@ExtendWith(MockitoExtension.class)
public class DiscountedCheckoutServiceTest {

	@Mock
	private static ShopItemRepository shopItemRepository;
	
	@InjectMocks
	private static CheckoutService checkoutService;
	
	@BeforeAll
	public static void setUp() throws Exception {
		shopItemRepository = new ShopItemRepository();
		checkoutService = new DiscountedCheckoutService();
	}
	
	@Test
	public void testCalculateTotal() throws Exception {
		when(shopItemRepository.getShopItemPrice("apple")).thenReturn(MockData.getShopItemPrice("apple"));
		when(shopItemRepository.getShopItemPrice("orange")).thenReturn(MockData.getShopItemPrice("orange"));
		BigDecimal total = checkoutService.calculateTotal(MockData.getMapOfItems(Arrays.asList("Apple", "Apple",
				"Orange", "Apple")));
		assertEquals(new BigDecimal("1.45").setScale(2, RoundingMode.CEILING),
				total);
	}
	
	@Test
	public void testCalculateTotalCaseSensitive() throws Exception {
		when(shopItemRepository.getShopItemPrice("apple")).thenReturn(MockData.getShopItemPrice("apple"));
		when(shopItemRepository.getShopItemPrice("orange")).thenReturn(MockData.getShopItemPrice("orange"));
		BigDecimal total = checkoutService.calculateTotal(MockData.getMapOfItems(Arrays.asList("Apple", "apple",
				"orange", "APPLE")));

		assertEquals(new BigDecimal("1.45").setScale(2, RoundingMode.CEILING),
				total);
	}
	
	@Test
	public void testCalculateTotalApple() throws Exception {
		when(shopItemRepository.getShopItemPrice("apple")).thenReturn(MockData.getShopItemPrice("apple"));
		BigDecimal total = checkoutService.calculateTotal(MockData.getMapOfItems(Arrays.asList("Apple", "APPLE")));

		assertEquals(new BigDecimal("0.60").setScale(2, RoundingMode.CEILING),
				total);
	}
	
	@Test
	public void testCalculateTotalOrange() throws Exception {
		when(shopItemRepository.getShopItemPrice("orange")).thenReturn(MockData.getShopItemPrice("orange"));
		BigDecimal total = checkoutService.calculateTotal(MockData.getMapOfItems(Arrays.asList("Orange", "ORANGE", "orange")));

		assertEquals(new BigDecimal("0.50").setScale(2, RoundingMode.CEILING),
				total);
	}
	
	@Test
	public void testCalculateTotalCombined() throws Exception {
		when(shopItemRepository.getShopItemPrice("apple")).thenReturn(MockData.getShopItemPrice("apple"));
		when(shopItemRepository.getShopItemPrice("orange")).thenReturn(MockData.getShopItemPrice("orange"));
		BigDecimal total = checkoutService.calculateTotal(MockData.getMapOfItems(Arrays.asList("Apple", "APPLE", "Orange", "ORANGE", "orange")));

		assertEquals(new BigDecimal("1.10").setScale(2, RoundingMode.CEILING),
				total);
	}
	
	@Test
	public void testCalculateTotalNoItems() throws Exception {
		BigDecimal total = checkoutService.calculateTotal(MockData.getMapOfItems(Arrays.asList()));

		assertEquals(new BigDecimal("0.00").setScale(2, RoundingMode.CEILING),
				total);
	}
	
}
