package Zomato;

public class Upi implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Payed amount "+amount+" using Upi");
    }
}
