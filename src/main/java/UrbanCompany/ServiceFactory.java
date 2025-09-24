package UrbanCompany;

public class ServiceFactory {
    public static Service createService(String type, String name,double price){
        switch (type.toLowerCase()){
            case "cleaning":
                return new CleaningService(name,price);
            case "beauty":
                return new BeautyService(name,price);
            case "plumbing":
                return new PlumbingService(name,price);
            default:
                throw new IllegalArgumentException("Unknown service type "+ type);
        }
    }
}