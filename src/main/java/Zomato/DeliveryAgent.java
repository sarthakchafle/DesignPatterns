package Zomato;

public class DeliveryAgent extends User{
    public DeliveryAgent(String name, String contact) {
        super(name, contact);
    }

    @Override
    void displayDetails() {
        System.out.println("Customer: "+name+" Email: "+contact);
    }
}
