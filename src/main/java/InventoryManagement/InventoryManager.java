package InventoryManagement;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
//   singleton
    private static InventoryManager instance;
    private List<Warehouse> warehouseList;
    private ProductFactory productFactory;
    private ReplenishmentStrategy replenishmentStrategy;

    private InventoryManager(){
        warehouseList=new ArrayList<>();
        productFactory = new ProductFactory();
    }
    public static synchronized InventoryManager getInstance(){
        if(instance==null){
            instance= new InventoryManager();
        }
        return instance;
    }
    // Strategy pattern method
    public void setReplenishmentStrategy(ReplenishmentStrategy strategy) {
        this.replenishmentStrategy = strategy;
    }

    // Warehouse management
    public void addWarehouse(Warehouse warehouse) {
        warehouseList.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        warehouseList.remove(warehouse);
    }

    // Product inventory operations
    public Product getProductBySku(String sku) {
        for (Warehouse warehouse : warehouseList) {
            Product product = warehouse.getProductBySku(sku);
            if (product != null) {
                return product;
            }
        }
        return null;
    }

    // Check stock levels and apply replenishment strategy if needed
    public void checkAndReplenish(String sku) {
        Product product = getProductBySku(sku);
        if (product != null) {
            // If product is below threshold, notify observers
            if (product.getQuantity() < product.getThreshold()) {
//                notifyObservers(product);
                // Apply current replenishment strategy
                if (replenishmentStrategy != null) {
                    replenishmentStrategy.replinish(product);
                }
            }
        }
    }

    // Global inventory check
    public void performInventoryCheck() {
        for (Warehouse warehouse : warehouseList) {
            for (Product product : warehouse.getAllProducts()) {
                if (product.getQuantity() < product.getThreshold()) {
//                    notifyObservers(product);
                    if (replenishmentStrategy != null) {
                        replenishmentStrategy.replinish(product);
                    }
                }
            }
        }
    }
}
