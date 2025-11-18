package InventoryManagement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectronicProduct extends Product{
    private String brand;
    private int warrantyPeriod;
    public ElectronicProduct(String sku, String name, double price, int quantity, int threshold, ProductCategory category) {
        super(sku, name, price, quantity, threshold, category);
    }

    public ElectronicProduct(String sku, String name, double price, int quantity,int threshold) {
        super(sku, name, price, quantity,threshold);
    }
}
