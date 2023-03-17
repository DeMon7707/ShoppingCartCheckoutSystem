package shoppingcartcheckoutsystem.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {

	public static final BigDecimal convertToPounds(BigDecimal penny) {
		return penny.divide(new BigDecimal("100")).setScale(2, RoundingMode.CEILING);
	}
	
	public static final Integer getOffers(String itemName, Long quantity, Integer itemPrice) {
		Integer itemDiscount = null;
		switch(itemName.toLowerCase()) {
			case "apple" : 
						itemDiscount = new Double(quantity / Constants.APPLE_BUY_ONE_GET_ONE).intValue() * itemPrice;
						break;
			case "orange" : 
						itemDiscount = new Double(quantity / Constants.ORANGE_BUY_TWO_GET_ONE).intValue() * itemPrice;
						break;
			default : 
					itemDiscount = 0;
					break;
		}
		
		return itemDiscount;
	}
	
}
