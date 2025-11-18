package StockBroker.Entity;

import StockBroker.Enums.Exchange;
import StockBroker.Enums.OrderType;
import StockBroker.Enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Order {
    TransactionType transactionType;
    OrderType orderType;
    int quantity;
    double price;
    Stock stock;
    Exchange exchange;
}
