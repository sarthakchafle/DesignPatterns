package InventoryManagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class Warehouse {
    private int id;
    private String name;
    private String location;
    private Map<String, Product> productsMap; // SKU -> Product

    public Warehouse(String s) {
        this.name=s;
    }

    public void addProduct(Product product, int quantity){
        String sku = product.getSku();
        if(productsMap.containsKey(sku)){
            Product existingProduct = productsMap.get(sku);
            existingProduct.addProduct(quantity);
        }else{
            product.setQuantity(quantity);
            productsMap.put(sku,product);
        }
        System.out.println(quantity + " units of " + product.getName()
                + " (SKU: " + sku + ") added to " + name
                + ". New quantity: " + getAvailableQuantity(sku));
    }
    public boolean removeProduct(String sku, int quantity) {
        if (productsMap.containsKey(sku)) {
            Product product = productsMap.get(sku);
            int currentQuantity = product.getQuantity();
            if (currentQuantity >= quantity) {
                // Sufficient inventory to remove
                product.removeProduct(quantity);
                System.out.println(quantity + " units of " + product.getName()
                        + " (SKU: " + sku + ") removed from " + name
                        + ". Remaining quantity: " + product.getQuantity());
                // If quantity becomes zero, consider removing the product entirely
                if (product.getQuantity() <= 0) {
                    // Remove products with zero quantity
                    productsMap.remove(sku);
                    System.out.println("Product " + product.getName()
                            + " removed from inventory as quantity is now zero.");
                }
                return true;
            } else {
                System.out.println("Error: Insufficient inventory. Requested: "
                        + quantity + ", Available: " + currentQuantity);
                return false;
            }
        } else {
            System.out.println(
                    "Error: Product with SKU " + sku + " not found in " + name);
            return false;
        }
    }
    public int getAvailableQuantity(String sku) {
        if (productsMap.containsKey(sku)) {
            return productsMap.get(sku).getQuantity();
        }
        return 0; // Product not found
    }
    // Get a product by SKU
    public Product getProductBySku(String sku) {
        return productsMap.get(sku);
    }

    // Get all products in this warehouse
    public Collection<Product> getAllProducts() {
        return productsMap.values();
    }
}
