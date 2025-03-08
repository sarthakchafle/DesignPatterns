package Zomato;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Order {
    private String orderId;
    private Customer customer;
    private Restaurant restaurant;
    private List<MenuItem> items;
    private double totalPrice;
    private String status;
    private OrderNotifier notifier;

    public Order(OrderBuilder orderBuilder) {
        this.orderId = UUID.randomUUID().toString();
        this.customer = orderBuilder.customer;
        this.restaurant = orderBuilder.restaurant;
        this.items = orderBuilder.items;
        this.totalPrice = orderBuilder.totalPrice;
        this.status = "Pending";
        this.notifier = orderBuilder.notifier;
        notifier.notifyUsers("Order placed, order id: "+ orderId+" Total: Rs. "+totalPrice);
    }

    public static class OrderBuilder {
        private Customer customer;
        private Restaurant restaurant;
        private List<MenuItem> items;
        private double totalPrice;
        private OrderNotifier notifier;

        public OrderBuilder(Customer customer, Restaurant restaurant, OrderNotifier notifier) {
            this.customer = customer;
            this.restaurant = restaurant;
            this.notifier = notifier;
        }

        public OrderBuilder addItems(List<MenuItem> items) {
            this.items = items;
            this.totalPrice = items.stream().mapToDouble(MenuItem::getPrice).sum();
            return this;
        }

        public Order build() {
            if (items == null) {
                throw new IllegalStateException("Cannot place order with an empty cut");
            }
            return new Order(this);
        }
    }

    public void updateOrderStatus(String newStatus) {
        this.status = newStatus;
        notifier.notifyUsers("order "+orderId+" status updated to: "+status);
    }
    public void displayOrderDetails(){
        System.out.println("\nOrder ID: "+ orderId);
        System.out.println("Customer: "+customer.name);
        System.out.println("Order items: ");
        for (MenuItem item:items) {
            System.out.println("Total price: Rs. " + totalPrice);
            System.out.println("Status: " + status);
        }
    }
    public double getTotalPrice(){
        return totalPrice;
    }
}

