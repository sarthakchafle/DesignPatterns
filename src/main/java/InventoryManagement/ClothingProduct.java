package InventoryManagement;

public class ClothingProduct extends Product{
    String size;
    String color;

    public ClothingProduct(String sku, String name, double price, int quantity, int threshold, ProductCategory category) {
        super(sku, name, price, quantity, threshold, category);
    }

    public ClothingProduct(String sku, String name, double price, int quantity,int threshold) {
        super(sku,name,price,quantity,threshold);
    }
}
