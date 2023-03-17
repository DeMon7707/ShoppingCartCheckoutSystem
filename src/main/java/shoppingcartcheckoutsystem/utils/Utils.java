package shoppingcartcheckoutsystem.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {

	public static final BigDecimal convertToPounds(BigDecimal penny) {
		return penny.divide(new BigDecimal("100")).setScale(2, RoundingMode.CEILING);
	}
	
}
