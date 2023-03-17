package shoppingcartcheckoutsystem;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import shoppingcartcheckoutsystem.controller.CheckoutController;
import shoppingcartcheckoutsystem.model.ShopItem;

@SpringBootApplication
public class ShoppingCartCheckoutSystem {

	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartCheckoutSystem.class.getName());
	
	public static List<ShopItem> shopItems;
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartCheckoutSystem.class, args);
		
		Scanner sc = new Scanner(System.in);
		try {
			logger.info("Welcome to Checkout System...!");
			System.out.println("Welcome to Checkout System...!");
			
			CheckoutController checkoutController = new CheckoutController();
			
			SampleData.prepareData();
			List<String> availableShopItems = shopItems.stream().map(s -> s.getShopItemName().toLowerCase()).collect(Collectors.toList());
			System.out.println("\nAvailable Items: " + availableShopItems.toString());
			
			String stringItems;
			List<String> requestedItems;
			List<String> items;
			
			while(true) {
				System.out.print("\nEnter list of items to checkout (Either Apple or Orange only, comma seperated): ");
				stringItems = sc.nextLine();
				if(stringItems.isEmpty()) {
					System.out.println("Items list can't be empty...! ");
					continue;
				}
				
				requestedItems = Arrays.asList(stringItems.split(","));
				items = requestedItems.stream().map(i -> i.trim()).collect(Collectors.toList());
				if(!validateInput(items, availableShopItems)) {
					System.out.println("Some items don't exist...!");
					continue;
				}
				else 
					break;
			}
					
			//List<String> items = Arrays.asList("Apple", "Apple", "Orange", "Apple");
			
			System.out.println("\nList of items to checkout: " + items.toString());
			System.out.println("Total: \u00A3" + checkoutController.getTotal(items));
			
		} catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			logger.error(e.getMessage());
		} finally {
			System.out.println("\nThank you...!");
			logger.info("Thank you...!");
			sc.close();
		}
	}
	
	public static boolean validateInput(List<String> items, List<String> availableShopItems) {
		for(String item : items) {
			if(!availableShopItems.contains(item.toLowerCase()))
				return false;
		}
		
		return true;
	}

}
