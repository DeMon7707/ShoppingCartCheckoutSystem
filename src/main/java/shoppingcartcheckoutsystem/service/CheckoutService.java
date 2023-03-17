package shoppingcartcheckoutsystem.service;

import java.math.BigDecimal;
import java.util.Map;

public interface CheckoutService {

	public BigDecimal calculateTotal(Map<String, Long> items) throws Exception;
	
}
