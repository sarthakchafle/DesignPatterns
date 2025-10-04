package StockBroker;

import StockBroker.Entity.Order;
import StockBroker.Entity.Stock;
import StockBroker.Entity.User;
import StockBroker.Enums.Exchange;
import StockBroker.Enums.OrderType;
import StockBroker.Enums.TransactionType;

public class StockBrokerMain {
    public static void main(String[] args) {
        User user = new User("u1");
        Stock stock = new Stock(Exchange.NSE,"TCS",2200.0);
        Order order = new Order(TransactionType.BUY, OrderType.LIMIT,20,10000,stock,Exchange.NSE);
        OrderValidator orderValidator = new OrderValidator();
        OrderExecutor orderExecutor = new OrderExecutor();
        OrderManager orderManager= new OrderManager(orderValidator,orderExecutor);
        orderManager.placeOrder(user.getUserId(),order);
    }
}
