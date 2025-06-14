package InventoryManagement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Get the singleton instance of InventoryManager
        InventoryManager inventoryManager = InventoryManager.getInstance();

        // Create and add warehouses
        Warehouse warehouse1 = new Warehouse("Warehouse 1");
        Warehouse warehouse2 = new Warehouse("Warehouse 2");
        inventoryManager.addWarehouse(warehouse1);
        inventoryManager.addWarehouse(warehouse2);

        // Create products using ProductFactory
        ProductFactory productFactory = new ProductFactory();
        Product laptop = productFactory.createProduct(
                ProductCategory.ELECTRONICS, "SKU123", "Laptop", 1000.0, 50,10);
        Product tShirt = productFactory.createProduct(
                ProductCategory.CLOTHING, "SKU456", "T-Shirt", 20.0, 200,20);
        Product apple = productFactory.createProduct(
                ProductCategory.GROCERY, "SKU789", "Apple", 1.0, 100,1000);

        // Add products to warehouses
        warehouse1.addProduct(laptop, 15);
        warehouse1.addProduct(tShirt, 20);
        warehouse2.addProduct(apple, 50);

        InventoryObserver supplier = new SupplierNotifier("bob","bob@gmail.com");
        List<String> adminUsers = new ArrayList<>();
        adminUsers.add("admin1");
        adminUsers.add("admin2");
        adminUsers.add("admin3");
        InventoryObserver dashboard = new DashboardAlertSystem("dashboard",adminUsers);

        inventoryManager.addObserver(supplier);
        inventoryManager.addObserver(dashboard);
        // Set replenishment strategy to Just-In-Time
        inventoryManager.setReplenishmentStrategy(new JustInTimeReplenishmentStrategy());

        // Perform inventory check and replenish if needed
        inventoryManager.performInventoryCheck();

        // Switch replenishment strategy to Bulk Order
        inventoryManager.setReplenishmentStrategy(new BulkReplenishmentStrategy());

        // Replenish a specific product if needed
        inventoryManager.checkAndReplenish("SKU789");
    }
}
