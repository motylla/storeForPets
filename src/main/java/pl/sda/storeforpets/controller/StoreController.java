package pl.sda.storeforpets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.storeforpets.model.Cart;
import pl.sda.storeforpets.model.Item;
import pl.sda.storeforpets.model.enums.CategoryEnum;
import pl.sda.storeforpets.service.CartService;
import pl.sda.storeforpets.service.ItemService;

import java.util.List;

import static pl.sda.storeforpets.model.enums.CategoryEnum.*;

@Controller
public class StoreController {
    private ItemService itemService;
    private CartService cartService;

    @Autowired
    public StoreController(ItemService itemService, CartService cartService) {
        this.itemService = itemService;
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Item> items = itemService.showItemsWithDiscount();
        model.addAttribute("items", items);
        Cart cart = new Cart();
        model.addAttribute("cart", cart);
        model.addAttribute("lastCart", cartService.getLastCart(cart));
        return "index";
    }

    @GetMapping("/dogs")
    public String showDogs(Model model) {
        CategoryEnum category = Psy;
        showItemsByCategory(model, category);
        Cart cart = new Cart();
        model.addAttribute("lastCart", cartService.getLastCart(cart));
        return "dogs";
    }

    @GetMapping("/cats")
    public String showCats(Model model) {
        CategoryEnum category = Koty;
        showItemsByCategory(model, category);
        Cart cart = new Cart();
        model.addAttribute("lastCart", cartService.getLastCart(cart));
        return "cats";
    }

    @GetMapping("/amphibians")
    public String showPlazy(Model model) {
        CategoryEnum category = Plazy;
        showItemsByCategory(model, category);
        Cart cart = new Cart();
        model.addAttribute("lastCart", cartService.getLastCart(cart));
        return "amphibians";
    }

    @GetMapping("/reptiles")
    public String showGady(Model model) {
        CategoryEnum category = Gady;
        showItemsByCategory(model, category);
        Cart cart = new Cart();
        model.addAttribute("lastCart", cartService.getLastCart(cart));
        return "reptiles";
    }

    @GetMapping("/rodents")
    public String showGryzonie(Model model) {
        CategoryEnum category = Gryzonie;
        showItemsByCategory(model, category);
        Cart cart = new Cart();
        model.addAttribute("lastCart", cartService.getLastCart(cart));
        return "rodents";
    }

    public void showItemsByCategory(Model model, CategoryEnum category) {
        List<Item> itemsByCategory = itemService.showItemByCategory(category);
        model.addAttribute("items", itemsByCategory);
    }

    @GetMapping("/cart/{cartId}")
    public String shoppingCart(Model model, @PathVariable long cartId) {
        Cart cart = cartService.getCartById(cartId);
        model.addAttribute("cart", cart);
        return "shoppingCart";
    }

    @PostMapping("/addItem/{itemId}")
    public String addItem(@PathVariable long itemId, @ModelAttribute Cart cart) {
        Item item = itemService.showItemById(itemId);
        cartService.saveItem(cart, item);
        return "redirect:/";
    }

    @DeleteMapping("/deleteCart/{cartId}")
    public String deleteCart(@PathVariable long cartId) {
        Cart cart = cartService.getCartById(cartId);
        System.out.println(cart.getId());
        cartService.deleteCart(cart);
        return "redirect:/";
    }

    @PutMapping("/incrementItem/{cartId}")
    public String incrementItem(@PathVariable long cartId) {
        Cart cart = cartService.getCartById(cartId);
        cartService.incrementItem(cart);
        return "redirect:/cart/" + cartId;
    }

    @PutMapping("/decrementItem/{cartId}")
    public String decrementItem(@PathVariable long cartId) {
        Cart cart = cartService.getCartById(cartId);
        cartService.decrementItem(cart);
        return "redirect:/cart/" + cartId;
    }


}
