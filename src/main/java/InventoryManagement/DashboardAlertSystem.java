package InventoryManagement;

import java.util.List;

public class DashboardAlertSystem implements InventoryObserver{
    private String alertLevel;
    private List<String> adminUsers;

    public DashboardAlertSystem(String alertLevel, List<String> adminUsers) {
        this.alertLevel = alertLevel;
        this.adminUsers = adminUsers;
    }

    @Override
    public void update(Product product) {
        double stockPercentage =
                ((double) product.getQuantity() / product.getThreshold()) * 100;

        if (stockPercentage <= 25) {
            // Critical alert - red notification
            System.out.println("CRITICAL ALERT: " + product.getName()
                    + " stock critically low at " + product.getQuantity() + " units ("
                    + String.format("%.1f", stockPercentage) + "% of threshold)");
            notifyAdmins(product, "CRITICAL");
        } else if (stockPercentage <= 50) {
            // Warning alert - yellow notification
            System.out.println("WARNING ALERT: " + product.getName()
                    + " stock low at " + product.getQuantity() + " units ("
                    + String.format("%.1f", stockPercentage) + "% of threshold)");
            notifyAdmins(product, "WARNING");
        }
    }

    private void notifyAdmins(Product product, String level) {
        for (String admin : adminUsers) {
            System.out.println("Dashboard notification sent to admin: " + admin
                    + " - " + level + " level alert for " + product.getName());
            // Actual implementation would update dashboard UI and push notifications
        }
    }
}
