package Zomato;

public class Customer extends User{

    public Customer(String name, String contact) {
        super(name, contact);
    }

    @Override
    void displayDetails() {
        System.out.println("Customer: "+name+" Email: "+contact);
    }
}
