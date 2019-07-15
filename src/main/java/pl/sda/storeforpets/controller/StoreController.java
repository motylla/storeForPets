package pl.sda.storeforpets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.storeforpets.service.ItemService;

@Controller
public class StoreController {
    ItemService itemService;

    @Autowired
    public StoreController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String home(Model model){
        return "index";
    }
}
