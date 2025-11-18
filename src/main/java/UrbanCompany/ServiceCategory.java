package UrbanCompany;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ServiceCategory {
    private String categoryName;
    private List<ServiceCategory> subCategories = new ArrayList<>();
    private List<Service> services = new ArrayList<>();

    public ServiceCategory(String name){
        this.categoryName=name;
    }
    public void addService(Service service){
        services.add(service);
    }
    public void addSubCategory(ServiceCategory category){
        subCategories.add(category);
    }
    public void displayHierarchy(String prefix) {
        System.out.println(prefix + "Category: " + categoryName);
        for (Service service : services) {
            System.out.println(prefix + "  - Service: " + service.getName() + " (₹" + service.getPrice() + ")");
        }
        for (ServiceCategory sub : subCategories) {
            sub.displayHierarchy(prefix + "  ");
        }
    }
}
