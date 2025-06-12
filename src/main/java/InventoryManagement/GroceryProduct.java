package InventoryManagement;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GroceryProduct extends Product{
    private Date expiryDate;
    private boolean isRefrigerated;


    public GroceryProduct(String sku, String name, double price, int quantity, int threshold, ProductCategory category) {
        super(sku, name, price, quantity, threshold, category);
    }

    public GroceryProduct(String sku, String name, double price, int quantity,int threshold) {
        super(sku, name, price, quantity,threshold);
    }
}
