package ShoppingCart;

import ShoppingCart.Cart.Cart;
import ShoppingCart.Coupons.Coupon;
import ShoppingCart.Discounts.DiscountStrategyFactory;
import ShoppingCart.Models.Category;
import ShoppingCart.Models.DiscountType;
import ShoppingCart.Models.Product;

import java.util.Map;

public class Main {// Create a Cart

    public static void main(String[] args) {
        Cart cart = new Cart();

        // Add Products to the Cart
        Product shirt = new Product("Shirt", Category.APPAREL, 800);
        Product pan = new Product("Pan", Category.KITCHENWARE, 500);
        Product doll = new Product("Doll", Category.TOYS, 300);
        Product book = new Product("Fiction Book", Category.BOOKS, 600);

        cart.addProduct(shirt);
        cart.addProduct(pan);
        cart.addProduct(doll);
        cart.addProduct(book);

        // Create and Add Coupons
        Coupon apparelCoupon = new Coupon(Category.APPAREL,
                DiscountStrategyFactory.createDiscountStrategy(DiscountType.PERCENTAGE, 20, null));
        Coupon kitchenwareCoupon = new Coupon(Category.KITCHENWARE,
                DiscountStrategyFactory.createDiscountStrategy(DiscountType.PERCENTAGE, 10, 50.0));
            Coupon toysCoupon = new Coupon(Category.TOYS,
                    DiscountStrategyFactory.createDiscountStrategy(DiscountType.FLAT, 50, 0.0));
        Coupon booksCoupon = new Coupon(Category.BOOKS,
                DiscountStrategyFactory.createDiscountStrategy(DiscountType.PERCENTAGE, 15, 100.0));

        cart.addCoupon(apparelCoupon);
        cart.addCoupon(kitchenwareCoupon);
        cart.addCoupon(toysCoupon);
        cart.addCoupon(booksCoupon);

        Map<Product, Double> discountedPrices = cart.applyCoupons();

        System.out.println("Final Prices After Applying Best Coupons:");
        for(
                Map.Entry<Product, Double> entry :discountedPrices.entrySet())

        {
            System.out.println(entry.getKey().getName() + ": Rs " + entry.getValue());
        }

        // Print Total Price After Discounts
        System.out.println("Total Price After Discounts: Rs "+cart.calculateTotal());
    }
}
