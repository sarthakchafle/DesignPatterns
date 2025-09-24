package UrbanCompany;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager {
    private List<Service> previousOrders = new ArrayList<>();

    public Service createService(String type, String name, double price) {
        Service service = ServiceFactory.createService(type, name, price);
        previousOrders.add(service);
        return service;
    }

    public List<Service> getPreviousOrders() {
        return previousOrders;
    }
}