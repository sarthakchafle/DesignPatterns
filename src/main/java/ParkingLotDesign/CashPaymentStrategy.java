package ParkingLotDesign;

public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid via cash");
    }
}
