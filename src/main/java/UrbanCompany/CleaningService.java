package UrbanCompany;

public class CleaningService extends Service{
    public CleaningService(String name, double price) {
        super(name, price);
    }

    @Override
    void performService() {
        System.out.println("Performing cleaning service "+getName());
    }
}
