package ShoppingCart.Coupons;

import ShoppingCart.Discounts.DiscountStrategy;
import ShoppingCart.Models.Category;
import ShoppingCart.Models.Product;

public class Coupon {
    private Category category;
    private DiscountStrategy discountStrategy;

    public Category getCategory() {
        return category;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public Coupon(Category category, DiscountStrategy discountStrategy) {
        this.category = category;
        this.discountStrategy = discountStrategy;
    }

    public boolean isApplicable(Product product) {
        return product.getCategory() == category;
    }

    public double applyDiscount(Product product) {
        if (!isApplicable(product)) return product.getPrice();
        return discountStrategy.applyDiscount(product);
    }
}
