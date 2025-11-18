package InventoryManagement;

public class BulkReplenishmentStrategy implements ReplenishmentStrategy{
    @Override
    public void replinish(Product product) {
        System.out.println("Replenishment done using BulkReplenishmentStrategy for product "+product);
    }
}
