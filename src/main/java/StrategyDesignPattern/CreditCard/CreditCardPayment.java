package StrategyDesignPattern.CreditCard;

import StrategyDesignPattern.Strategy.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    String cardNumber;
    String name;

    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}
