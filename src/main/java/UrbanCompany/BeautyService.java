package UrbanCompany;

public class BeautyService extends Service{

    public BeautyService(String name, double price) {
        super(name, price);
    }
    @Override
    void performService() {
        System.out.println("Performing beauty service "+getName());
    }
}
