package pl.sda.storeforpets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.storeforpets.model.Cart;
import pl.sda.storeforpets.model.Item;
import pl.sda.storeforpets.repository.CartRepository;

import java.util.List;

@Service
@Transactional
public class CartService {
    private CartRepository cartRepository;


    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
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

    public Cart getLastCart(Cart cart) {
        List<Cart> cartList = cartRepository.findAll();
        int lastCart = cartList.size() - 1;
        Cart cartObject = cartList.get(lastCart);
        long id = cartObject.getId();
        return cartRepository.getOne(id);
    }

    public Cart incrementItem(Cart cart) {
        cart.setStock(cart.getStock() + 1);
        return setCartWithRightAmount(cart);
    }

    public Cart decrementItem(Cart cart) {
        cart.setStock(cart.getStock() - 1);
        return setCartWithRightAmount(cart);
    }

    private Cart setCartWithRightAmount(Cart cart) {
        if (cart.getItem().getDiscount() != 0) {
            cart.setAmount(((cart.getItem().getPrice() * (100 - cart.getItem().getDiscount())) / 100) * cart.getStock());
        } else {
            cart.setAmount(cart.getItem().getPrice() * cart.getStock());
        }
        return cartRepository.save(cart);
    }

    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }


}
