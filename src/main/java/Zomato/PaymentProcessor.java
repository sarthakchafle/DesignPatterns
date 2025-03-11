package Zomato;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void processPayment(double amount){
        paymentStrategy.pay(amount);
    }

}
