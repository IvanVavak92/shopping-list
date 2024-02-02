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
        List<ShopItem> availableItems = shopItemService.filterAvailable();
        model.addAttribute("shopItems", availableItems);
        return "home";
    }

    @GetMapping("/cheapest-first")
    public String cheapestFirst(Model model) {
        List<ShopItem> fromCheapest = shopItemService.getSortedItemsByPrice();
        model.addAttribute("shopItems", fromCheapest);
        return "home";
    }

    @GetMapping("/contains-nike")
    public String filterItemsWithNike(Model model) {
        List<ShopItem> nikeItems = shopItemService.filterNike();
        model.addAttribute("shopItems", nikeItems);
        return "home";
    }

    @GetMapping("/average-stock")
    public String AveragePrice(Model model) {
        double aver = shopItemService.averageStock();
        model.addAttribute("averageStock", aver);
        model.addAttribute("pageType", "average");
        return "some-info";
    }

    @GetMapping("/most-expensive")
    public String MostExpensiveItemForSomeInfo(Model model) {
        ShopItem mostExpensiveItem = shopItemService.findMostExpensiveItem();
        model.addAttribute("mostExpensiveItem", mostExpensiveItem);
        model.addAttribute("pageType", "mostExpensive");
        return "some-info";
    }

    @GetMapping("/some-info")
    public String someInfo() {
        return "some-info";
    }

}
