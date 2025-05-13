package Zomato;

public class SmsNotifier implements Observer{
    private String phoneNumber;

    public SmsNotifier(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String message) {
        System.out.println("SMS sent to "+ phoneNumber +": "+message);
    }
}
