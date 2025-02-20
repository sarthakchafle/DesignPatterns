package ShoppingCart.Discounts;

import ShoppingCart.Models.DiscountType;

public class DiscountStrategyFactory {
    public static DiscountStrategy createDiscountStrategy(DiscountType discountType, double value, Double maxDiscount){
        switch (discountType){
            case FLAT:
                return new FlatDiscountStrategy(value);
            case PERCENTAGE:
                return new PercentageDiscountStrategy(value,maxDiscount);
            default:
                throw new IllegalArgumentException("Invalid Discount type");
        }
    }
}
