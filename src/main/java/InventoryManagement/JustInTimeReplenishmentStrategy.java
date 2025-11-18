package InventoryManagement;

public class JustInTimeReplenishmentStrategy implements ReplenishmentStrategy{
    @Override
    public void replinish(Product product) {
        System.out.println("Replenishment done using JustInTimeReplenishmentStrategy for product "+product);
    }
}
