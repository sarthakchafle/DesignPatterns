package Zomato;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Payed amount "+amount+" using credit card");
    }
}
