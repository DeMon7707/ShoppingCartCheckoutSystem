package shoppingcartcheckoutsystem.repository;

import shoppingcartcheckoutsystem.ShoppingCartCheckoutSystem;

public class ShopItemRepository {

	public Integer getShopItemPrice(String itemName) {
		return ShoppingCartCheckoutSystem.shopItems.stream()
					.filter(i -> i.getShopItemName().toLowerCase().equals(itemName.toLowerCase()))
					.findAny()
					.get()
					.getShopItemPrice();
		
	}
	
}
