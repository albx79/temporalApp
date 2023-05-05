package it.albx79.shopping;

import java.util.ArrayList;

public class CartActivityImpl implements CartActivity {
    @Override
    public CartState addToCart(CartState cart, CartItem item) {
        var items = cart.items();
        items.add(item);
        return new CartState(items, cart.email());
    }

    @Override
    public CartState removeFromCart(CartState cart, CartItem item) {
        // todo actually inc/dec quantity if item already present
        var items = cart.items();
        items.remove(item);
        return new CartState(items, cart.email());
    }
}
