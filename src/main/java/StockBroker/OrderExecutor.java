package StockBroker;

import StockBroker.Entity.Order;

public class OrderExecutor {

    public void placeOrder(String userId, Order order){
        ExchangeConnector exchangeConnector= ExchangeConnector.getInstance();
        exchangeConnector.sendOrderToExchange(userId,order);
    }
}
