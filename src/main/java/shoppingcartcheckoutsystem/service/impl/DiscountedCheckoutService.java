package shoppingcartcheckoutsystem.service.impl;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import shoppingcartcheckoutsystem.repository.ShopItemRepository;
import shoppingcartcheckoutsystem.service.CheckoutService;
import shoppingcartcheckoutsystem.utils.Utils;

public class DiscountedCheckoutService implements CheckoutService {
	
	private static final Logger logger = LoggerFactory.getLogger(DiscountedCheckoutService.class.getName());

	private ShopItemRepository shopItemRepository= new ShopItemRepository();
		
	@Override
	public BigDecimal calculateTotal(Map<String, Long> items) throws Exception {
		logger.info("calculateTotal() called");
		BigDecimal discount = getDiscount(items);
		BigDecimal total = new BigDecimal("0.00");
		for(Entry<String, Long> entry : items.entrySet()){
			double subtotal = shopItemRepository.getShopItemPrice(entry.getKey()) * entry.getValue();
			total = total.add(new BigDecimal(subtotal));
		}
		
		logger.info("calculateTotal() completed");
		return Utils.convertToPounds(total.subtract(discount));
	}
	
	public BigDecimal getDiscount(Map<String, Long> items) throws Exception {
		logger.info("getDiscount() called");
		BigDecimal discount = new BigDecimal("0.00");
		for(Entry<String, Long> entry : items.entrySet()){
			Integer itemDiscount = 	Utils.getOffers(entry.getKey(), entry.getValue(), shopItemRepository.getShopItemPrice(entry.getKey()));
			discount = discount.add(new BigDecimal(itemDiscount));
		}
		
		logger.info("getDiscount() completed");
		return discount;
	}

}
