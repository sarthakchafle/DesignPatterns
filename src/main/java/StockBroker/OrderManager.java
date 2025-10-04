package StockBroker;

import StockBroker.Entity.Order;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderManager {
    OrderValidator orderValidator;
    OrderExecutor orderExecutor;
    public void placeOrder(String userId, Order order){
        if(orderValidator.validateOrder(userId,order)){
            orderExecutor.placeOrder(userId,order);
        }
    }
}
