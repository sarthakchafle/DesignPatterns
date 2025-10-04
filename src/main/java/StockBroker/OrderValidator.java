package StockBroker;

import StockBroker.Entity.Order;
import StockBroker.Entity.User;
import StockBroker.Entity.UserSystem;
import StockBroker.Enums.TransactionType;

public class OrderValidator {
    public boolean validateOrder(String userId, Order order){
        User user = UserSystem.getUser(userId);
        if(order.getTransactionType()== TransactionType.BUY){
            System.out.println("Checking if user has funds to buy");
        }else{
            System.out.println("Checking if the user has stocks to sell");
        }
        System.out.println("Assuming user has made valid order request");
        return true;
    }
}
