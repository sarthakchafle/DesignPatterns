package InventoryManagement;

public class ProductFactory {
    public Product createProduct(ProductCategory productCategory,String sku,String name,double price,int quantity,int threshold){
        switch (productCategory) {
            case ELECTRONICS:{
                return new ElectronicProduct(sku, name, price, quantity,threshold);
            }
            case CLOTHING:{
                return new ClothingProduct(sku, name, price, quantity,threshold);
            }
            case GROCERY: {
                return new GroceryProduct(sku, name, price, quantity,threshold);
            }
            default:{
                throw new IllegalArgumentException("Unsupported product category "+ productCategory);
            }
        }
    }
}
