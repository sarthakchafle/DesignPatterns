package InventoryManagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Product {
    private String sku;
    private String name;
    private double price;
    private int quantity;
    private int threshold;
    private ProductCategory category;
    Product(String sku,String name, double price,int quantity,int threshold){
        this.sku=sku;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.threshold=threshold;
    }
    void addProduct(int quantity){
        this.setQuantity(this.quantity+quantity);
    }
    void removeProduct(int quantity){
        this.setQuantity(this.quantity-quantity);
    }
}
