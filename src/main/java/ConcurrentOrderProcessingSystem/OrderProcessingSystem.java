package ConcurrentOrderProcessingSystem;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrderProcessingSystem {
    private static final ExecutorService pool = Executors.newFixedThreadPool(3);
    public static void main(String[] args) {
        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(OrderProcessingSystem::reserveInventory,pool);
        CompletableFuture<String> paymentFuture = CompletableFuture.supplyAsync(OrderProcessingSystem::processPayment,pool);
        CompletableFuture<String> shippingFuture = CompletableFuture.supplyAsync(OrderProcessingSystem::scheduleShipment,pool);

        CompletableFuture<Void> allFutures = CompletableFuture
                .allOf(inventoryFuture,paymentFuture,shippingFuture)
                .orTimeout(5, TimeUnit.SECONDS)
                .handle((ignored,ex)->{
                    if(ex !=null) {
                        System.out.println("\n❌ FAILURE detected: " + ex);
                        rollback(inventoryFuture,paymentFuture,shippingFuture);
                    }else{
                        System.out.println("\n✅ All tasks completed successfully!");
                        System.out.println("Inventory → " + inventoryFuture.join());
                        System.out.println("Payment   → " + paymentFuture.join());
                        System.out.println("Shipment  → " + shippingFuture.join());
                        System.out.println("\n🎉 ORDER CONFIRMED");
                    }
                    return null;
                });
        allFutures.join();

        pool.shutdown();
        System.out.println("\\n=== PROCESS FINISHED ===");
    }
    private static void rollback(
            CompletableFuture<String> inventory,
            CompletableFuture<String> payment,
            CompletableFuture<String> shipment) {

        System.out.println("\n initiating SAGA rollback");

        // Roll back inventory even if it FAILED
        if (inventory.isDone()) {
            System.out.println("-> rolling back inventory");
        }

        // Roll back payment only if it SUCCEEDED
        if (!payment.isCompletedExceptionally() && payment.isDone()) {
            System.out.println("-> refunding payment");
        }

        // Roll back shipment only if it SUCCEEDED
        if (!shipment.isCompletedExceptionally() && shipment.isDone()) {
            System.out.println("-> Cancelling shipment");
        }

        System.out.println("! Order cancelled due to failure\n");
    }

    private static String reserveInventory() {
        randomDelay();
        System.out.println("Reserving inventory...");
        if (randomFail()) throw new RuntimeException("Inventory system DOWN");
        return "Inventory Reserved";
    }

    private static String processPayment() {
        randomDelay();
        System.out.println("Processing payment...");
        if (randomFail()) throw new RuntimeException("Payment FAILED");
        return "Payment Successful";
    }

    private static String scheduleShipment() {
        randomDelay();
        System.out.println("Scheduling shipment...");
        if (randomFail()) throw new RuntimeException("Shipment API TIMEOUT");
        return "Shipment Scheduled";
    }
    private static void randomDelay() {
        try {
            Thread.sleep(500 + new Random().nextInt(500));
        } catch (InterruptedException ignored) {}
    }

    private static boolean randomFail() {
        return new Random().nextInt(10) < 3; // 30% failure rate
    }
}
