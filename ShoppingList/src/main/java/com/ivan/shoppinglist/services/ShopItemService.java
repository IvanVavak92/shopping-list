package com.ivan.shoppinglist.services;

import com.ivan.shoppinglist.models.ShopItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShopItemService {
    private List<ShopItem> shopItems;

    public ShopItemService() {
        this.shopItems = new ArrayList<>();
        shopItems.add(new ShopItem("Running shoes",
                "Nike running shoes for every day", 1000, 5));
        shopItems.add(new ShopItem("Printer", "Some HP printer", 3000, 2));
        shopItems.add(new ShopItem("Coca cola", "0.5 l standard coke", 25, 0));
        shopItems.add(new ShopItem("Wokin",
                "Chicken with fried rice nad Wokin sauce",119, 100));
        shopItems.add(new ShopItem("T-shirt", "Blue t-shirt", 300, 1));
    }

    public List<ShopItem> getShopItems() {
        return shopItems;
    }

    public List<ShopItem> filterAvailable(List<ShopItem> shopItems) {
        return shopItems.stream()
                .filter(item -> item.getQuantityOfStock() > 0)
                .collect(Collectors.toList());
    }

    public List<ShopItem> getAvailableItems() {
        List<ShopItem> allItems = getShopItems();
        return filterAvailable(allItems);
    }
}
