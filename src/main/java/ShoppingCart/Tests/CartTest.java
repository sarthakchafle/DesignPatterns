package ShoppingCart.Tests;

import ShoppingCart.Cart.Cart;
import ShoppingCart.Coupons.Coupon;
import ShoppingCart.Discounts.DiscountStrategyFactory;
import ShoppingCart.Models.Category;
import ShoppingCart.Models.DiscountType;
import ShoppingCart.Models.Product;
import org.junit.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {
    @Test
    public void testApplyCoupons() {
        Cart cart = new Cart();
        Product shirt = new Product("Shirt", Category.APPAREL, 800);
        Product pan = new Product("Pan", Category.KITCHENWARE, 500);
        Product doll = new Product("Doll", Category.TOYS, 300);
        Product book = new Product("Fiction Book", Category.BOOKS, 600);

        cart.addProduct(shirt);
        cart.addProduct(pan);
        cart.addProduct(doll);
        cart.addProduct(book);

        Coupon apparelCoupon = new Coupon(Category.APPAREL, DiscountStrategyFactory.createDiscountStrategy(DiscountType.PERCENTAGE, 20, null));
        Coupon kitchenwareCoupon = new Coupon(Category.KITCHENWARE, DiscountStrategyFactory.createDiscountStrategy(DiscountType.PERCENTAGE, 10, 50.0));
        Coupon toysCoupon = new Coupon(Category.TOYS, DiscountStrategyFactory.createDiscountStrategy(DiscountType.FLAT, 50, null));
        Coupon booksCoupon = new Coupon(Category.BOOKS, DiscountStrategyFactory.createDiscountStrategy(DiscountType.PERCENTAGE, 15, 100.0));

        cart.addCoupon(apparelCoupon);
        cart.addCoupon(kitchenwareCoupon);
        cart.addCoupon(toysCoupon);
        cart.addCoupon(booksCoupon);

        Map<Product, Double> discountedPrices = cart.applyCoupons();

        assertEquals(640, discountedPrices.get(shirt));
        assertEquals(450, discountedPrices.get(pan));
        assertEquals(250, discountedPrices.get(doll));
        assertEquals(510, discountedPrices.get(book));
        assertEquals(1850, cart.calculateTotal());
    }


}
