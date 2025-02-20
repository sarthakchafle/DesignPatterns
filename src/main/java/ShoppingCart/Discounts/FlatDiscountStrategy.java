package ShoppingCart.Discounts;

import ShoppingCart.Discounts.DiscountStrategy;
import ShoppingCart.Models.Product;

public class FlatDiscountStrategy implements DiscountStrategy {
    private double flatAmount;

    public FlatDiscountStrategy(double flatAmount) {
        this.flatAmount = flatAmount;
    }
    @Override
    public double applyDiscount(Product product) {
        return product.getPrice() - flatAmount;
    }
}
