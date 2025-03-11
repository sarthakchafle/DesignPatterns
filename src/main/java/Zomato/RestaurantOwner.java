package Zomato;

public class RestaurantOwner extends User{
    public RestaurantOwner(String name, String contact) {
        super(name, contact);
    }

    @Override
    void displayDetails() {
        System.out.println("Customer: "+name+" Email: "+contact);
    }
}
