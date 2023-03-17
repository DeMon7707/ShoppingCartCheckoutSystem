package shoppingcartcheckoutsystem.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import shoppingcartcheckoutsystem.service.CheckoutService;
import shoppingcartcheckoutsystem.service.impl.DiscountedCheckoutService;
import shoppingcartcheckoutsystem.service.impl.SimpleCheckoutService;

public class CheckoutController {
	
	private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class.getName());

	private CheckoutService checkoutService;
	
	public BigDecimal getTotal(List<String> items, boolean discountToApply) {
		logger.info("getTotal() called");
		Map<String, Long> groupedItems =  items.stream().map(i -> i.toLowerCase()).collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )
        );
		
		BigDecimal total = null;
		if(discountToApply) 
			checkoutService = new DiscountedCheckoutService();
		else 
			checkoutService = new SimpleCheckoutService();
		
		try {
			total = checkoutService.calculateTotal(groupedItems);
		} catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			System.out.println(e.getMessage());
		}
		
		logger.info("getTotal() completed");
		return total;
	}
	
}
