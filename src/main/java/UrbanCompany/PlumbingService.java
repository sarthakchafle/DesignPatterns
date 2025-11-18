package UrbanCompany;

public class PlumbingService extends Service{
    public PlumbingService(String name, double price) {
        super(name, price);
    }

    @Override
    void performService() {
        System.out.println("Performing plumbing service "+getName());
    }
}