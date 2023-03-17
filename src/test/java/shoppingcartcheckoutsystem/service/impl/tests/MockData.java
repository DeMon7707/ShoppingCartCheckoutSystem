package shoppingcartcheckoutsystem.service.impl.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import shoppingcartcheckoutsystem.model.ShopItem;

public class MockData {
	
	public static List<ShopItem> shopItems;
	
	static {
		shopItems = new ArrayList<>();
		shopItems.add(new ShopItem("Apple", 60));
		shopItems.add(new ShopItem("Orange", 25));
	}
	
	public static Integer getShopItemPrice(String itemName) {
		return shopItems.stream()
					.filter(i -> i.getShopItemName().toLowerCase().equals(itemName.toLowerCase()))
					.findAny()
					.get()
					.getShopItemPrice();
		
	}
	
	public static Map<String, Long> getMapOfItems(List<String> items) {
		Map<String, Long> groupedItems =  items.stream().map(i -> i.toLowerCase()).collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )
        );
		
		return groupedItems;
	}
	
}
