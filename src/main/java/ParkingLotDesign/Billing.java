package ParkingLotDesign;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Billing {
    double amount;
    private PaymentStrategy paymentStrategy;

    public void calculateBillAndPay(){
        if(amount>0){
            paymentStrategy.pay(amount);
        }else{
            System.out.println("Invalid!");
        }
    }

}
