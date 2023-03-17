package shoppingcartcheckoutsystem.model;

import java.util.concurrent.atomic.AtomicInteger;

public class ShopItem {

	private static final AtomicInteger _ITEM_ID = new AtomicInteger(0);
	
	private int shopItemId;
	private String shopItemName;
	private int shopItemPrice;
	
	public ShopItem(String shopItemName, int shopItemPrice) {
		super();
		this.shopItemId = _ITEM_ID.incrementAndGet();
		this.shopItemName = shopItemName;
		this.shopItemPrice = shopItemPrice;
	}

	public int getShopItemId() {
		return shopItemId;
	}

	public void setShopItemId(int shopItemId) {
		this.shopItemId = shopItemId;
	}

	public String getShopItemName() {
		return shopItemName;
	}

	public void setShopItemName(String shopItemName) {
		this.shopItemName = shopItemName;
	}

	public int getShopItemPrice() {
		return shopItemPrice;
	}

	public void setShopItemPrice(int shopItemPrice) {
		this.shopItemPrice = shopItemPrice;
	}

	@Override
	public String toString() {
		return "ShopItem [shopItemId=" + shopItemId + ", shopItemName=" + shopItemName + ", shopItemPrice="
				+ shopItemPrice + "]";
	}
	
}
