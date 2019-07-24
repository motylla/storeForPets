package pl.sda.storeforpets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.storeforpets.model.Cart;
import pl.sda.storeforpets.model.Item;
import pl.sda.storeforpets.repository.CartRepository;
import pl.sda.storeforpets.repository.ItemRepository;

import java.util.List;

@Service
@Transactional
public class CartService {
    private CartRepository cartRepository;
    private ItemRepository itemRepository;


    @Autowired
    public CartService(CartRepository cartRepository, ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    public Cart saveItem(Cart cart, Item item) {
        cart.setItem(item);
        cart.setStock(1);
        if (item.getDiscount() != 0) {
            cart.setAmount((item.getPrice() * (100 - item.getDiscount())) / 100);
        } else {
            cart.setAmount(item.getPrice() * cart.getStock());
        }
        return cartRepository.save(cart);
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.getOne(cartId);
    }


}
