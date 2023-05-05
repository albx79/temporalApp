package it.albx79.shopping;

import java.util.List;

public record CartState(List<CartItem> items, String email) {
}
