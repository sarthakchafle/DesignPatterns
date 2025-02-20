package ShoppingCart.Discounts;

import ShoppingCart.Discounts.DiscountStrategy;
import ShoppingCart.Models.Product;

public class PercentageDiscountStrategy implements DiscountStrategy {
    private double discountPercentage;
    private Double maxDiscount;

    public PercentageDiscountStrategy(double discountPercentage, Double maxDiscount) {
        this.discountPercentage = discountPercentage;
        this.maxDiscount = maxDiscount;
    }

    @Override
    public double applyDiscount(Product product) {
        double discount = (product.getPrice() * discountPercentage) / 100;
        if (maxDiscount != null) {
            discount = Math.min(discount, maxDiscount);
        }
        return product.getPrice() - discount;
    }
}
