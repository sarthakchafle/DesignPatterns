package StockBroker.Entity;

import StockBroker.Enums.Exchange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stock {
    Exchange exchange;
    String name;
    double price;
}
