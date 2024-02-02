package com.ivan.shoppinglist.controllers;

import com.ivan.shoppinglist.models.ShopItem;
import com.ivan.shoppinglist.services.ShopItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private final ShopItemService shopItemService = new ShopItemService();

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("shopItems", shopItemService.getShopItems());
        return "home";
    }

    @GetMapping("/only-available")
    public String availablePage(Model model) {
        List<ShopItem> availableItems = shopItemService.getAvailableItems();
        model.addAttribute("shopItems", availableItems);
        return "home";
    }
}
