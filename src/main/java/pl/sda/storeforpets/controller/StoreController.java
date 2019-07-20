package pl.sda.storeforpets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.storeforpets.model.Item;
import pl.sda.storeforpets.model.enums.CategoryEnum;
import pl.sda.storeforpets.service.ItemService;

import java.util.List;

import static pl.sda.storeforpets.model.enums.CategoryEnum.*;

@Controller
public class StoreController {
    ItemService itemService;

    @Autowired
    public StoreController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Item> items = itemService.showItemsWithDiscount();
        model.addAttribute("items", items);
        return "index";
    }

    @GetMapping("/dogs")
    public String showDogs (Model model) {
        CategoryEnum category = Psy;
        showItemsByCategory(model, category);
        return "dogs";

    }
    @GetMapping("/cats")
    public String showCats (Model model) {
        CategoryEnum category = Koty;
        showItemsByCategory(model, category);
        return "cats";

    }
    @GetMapping("/amphibians")
    public String showPlazy (Model model) {
        CategoryEnum category = Plazy;
        showItemsByCategory(model, category);
        return "amphibians";

    }
    @GetMapping("/reptiles")
    public String showGady (Model model) {
        CategoryEnum category = Gady;
        showItemsByCategory(model, category);
        return "reptiles";

    }
    @GetMapping("/rodents")
    public String showGryzonie (Model model) {
        CategoryEnum category = Gryzonie;
        showItemsByCategory(model, category);
        return "rodents";

    }

    public void showItemsByCategory(Model model, CategoryEnum category) {
        List<Item> itemsByCategory = itemService.showItemByCategory(category);
        model.addAttribute("items", itemsByCategory);
    }
}
