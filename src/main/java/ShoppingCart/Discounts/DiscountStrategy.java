package ShoppingCart.Discounts;

import ShoppingCart.Models.Product;

public interface DiscountStrategy {
    double applyDiscount(Product product);
}
