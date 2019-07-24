package pl.sda.storeforpets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.storeforpets.model.ContactMe;
import pl.sda.storeforpets.model.Item;
import pl.sda.storeforpets.model.enums.CategoryEnum;
import pl.sda.storeforpets.service.ContactMeService;
import pl.sda.storeforpets.service.ItemService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {
    private ItemService itemService;
    private ContactMeService contactMeService;


    @Autowired
    public AdminController(ItemService itemService, ContactMeService contactMeService) {
        this.itemService = itemService;
        this.contactMeService = contactMeService;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        return "admin/index";
    }

    @GetMapping("/admin/addItem")
    public String addItemView(Model model) {
        model.addAttribute("item", new Item());
        List<CategoryEnum> categories =
                new ArrayList<>(Arrays.asList(CategoryEnum.values()));
        model.addAttribute("categories", categories);
        return "admin/addItem";
    }

    @PostMapping("admin/addItem")
    public String addItem(@ModelAttribute Item item) {
        itemService.addItemToDatabase(item);
        return "redirect:/admin";

    }

    @GetMapping("/admin/readMessages")
    public String readMessages(Model model) {
        List<ContactMe> messages = contactMeService.showAllMessages();
        model.addAttribute("messages", messages);

        return "admin/tables";
    }
}
