package ShoppingCart.Cart;

import ShoppingCart.Coupons.Coupon;
import ShoppingCart.Models.Category;
import ShoppingCart.Models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private List<Product> products;
    private List<Coupon> coupons;

    public Cart() {
        this.products = new ArrayList<>();
        this.coupons = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addCoupon(Coupon coupon) {
        coupons.add(coupon);
    }

    public Map<Product, Double> applyCoupons() {
        Map<Category, Coupon> bestCoupons = new HashMap<>();
        for (Coupon c : coupons) {
            bestCoupons.putIfAbsent(c.getCategory(), c);
            Coupon existingCoupon = bestCoupons.get(c.getCategory());
            //sample product
            if (c.applyDiscount(new Product("sample", c.getCategory(), 1000)) > existingCoupon.applyDiscount(new Product("Sample", existingCoupon.getCategory(), 1000))) {
                bestCoupons.put(c.getCategory(), c);
            }
        }
        Map<Product, Double> discountedPrices = new HashMap<>();
        for (Product product : products) {
            Coupon bestCoupon = bestCoupons.get(product.getCategory());
            double finalPrice = (bestCoupon != null) ? bestCoupon.applyDiscount(product) : product.getPrice();
            discountedPrices.put(product, finalPrice);
        }
        return discountedPrices;
    }

    public double calculateTotal() {
        return applyCoupons().values().stream().mapToDouble(Double::doubleValue).sum();
    }
}

