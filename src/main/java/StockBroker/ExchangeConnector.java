package StockBroker;

import StockBroker.Entity.Order;
import StockBroker.Enums.Exchange;

public class ExchangeConnector {
    public static ExchangeConnector exchangeConnectorInstance;
    private ExchangeConnector(){}
    public static synchronized ExchangeConnector getInstance(){
        if(exchangeConnectorInstance==null){
            exchangeConnectorInstance =new ExchangeConnector();
        }
        return exchangeConnectorInstance;
    }
    public void sendOrderToExchange(String userId, Order order){
        System.out.println("Order is sent to exchange, Congratulations!🎊");
    }
}
