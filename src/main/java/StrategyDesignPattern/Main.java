package StrategyDesignPattern;

import StrategyDesignPattern.Cart.ShoppingCart;
import StrategyDesignPattern.CreditCard.CreditCardPayment;
import StrategyDesignPattern.Paypal.PayPalPayment;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay using Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9876", "John Doe"));
        cart.checkout(100);

        // Pay using PayPal
        cart.setPaymentStrategy(new PayPalPayment("john@example.com"));
        cart.checkout(50);
    }
}
