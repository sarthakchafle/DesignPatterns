package ParkingLotDesign;

public class Upi implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid via upi");
    }
}
