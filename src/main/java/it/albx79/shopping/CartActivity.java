package it.albx79.shopping;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface CartActivity {
    @ActivityMethod
    CartState addToCart(CartState cart, CartItem item);
    @ActivityMethod
    CartState removeFromCart(CartState cart, CartItem item);
}
