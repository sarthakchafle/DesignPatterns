package Zomato;

import java.util.List;

public class ZomatoMain {
    public static void main(String[] args) {
        User customer = new Customer("Alice","alice@gmail.com");
        RestaurantOwner restaurantOwner = (RestaurantOwner)new RestaurantOwner("Bob","bob@restaurant.com");
        Restaurant restaurant = RestaurantFactory.createRestaurant("Domino's", List.of(new BasicItem("Pizza",200)), restaurantOwner);
        OrderNotifier orderNotifier = new OrderNotifier();
        orderNotifier.addObser(new EmailNotifier(customer.getContact()));
        orderNotifier.addObser(new SmsNotifier("9405589803"));
        Cart cart = new Cart();
        cart.addItem(new BasicItem("Pizza",200));

        if(cart.isEmpty()){
            System.out.println("Cart is EMpty! cannot place an order");
            return;
        }
        Order order = new Order.OrderBuilder(customer,restaurant,orderNotifier).addItems(cart.getItems()).build();
        order.displayOrderDetails();;

        PaymentProcessor paymentProcessor = new PaymentProcessor(new CreditCardPayment());

        paymentProcessor.processPayment(order.getTotalPrice());

        order.updateOrderStatus("Preparing");
        order.updateOrderStatus("Out for delivery");
        order.updateOrderStatus("Delivered");

        cart.clearCart();
    }
}
