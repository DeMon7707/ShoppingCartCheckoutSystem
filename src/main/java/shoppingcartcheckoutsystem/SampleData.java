package shoppingcartcheckoutsystem;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import shoppingcartcheckoutsystem.model.ShopItem;

public class SampleData {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleData.class.getName());

	//prepared sample data 
	public static void prepareData() {
		logger.info("prepareData() called");
		try {
			ShoppingCartCheckoutSystem.shopItems = new ArrayList<>();
			ShoppingCartCheckoutSystem.shopItems.add(new ShopItem("Apple", 60));
			ShoppingCartCheckoutSystem.shopItems.add(new ShopItem("Orange", 25));
			
		} catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			logger.error(e.getMessage());
		}
		logger.info("prepareData() completed");
	}
	
}
