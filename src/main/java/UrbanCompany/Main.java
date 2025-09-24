package UrbanCompany;

public class Main {
    public static void main(String[] args) {
        ServiceCategory root = new ServiceCategory("Services");
        ServiceCategory home = new ServiceCategory("Home Service");
        ServiceCategory personal = new ServiceCategory("Personal care");

        root.addSubCategory(home);
        root.addSubCategory(personal);

        ServiceManager manager = new ServiceManager();

        Service cleaning = manager.createService("cleaning","Deep cleaning",2000);
        Service beauty = manager.createService("beauty","Bridal makeup",5000);
        Service plumbing = manager.createService("plumbing","Leakage fix",800);
//        Service gardening = manager.createService("gardening","Lawn moving",500);

        home.addService(cleaning);
        personal.addService(beauty);
        home.addService(plumbing);

        root.displayHierarchy("");

        cleaning.performService();
        beauty.performService();

        System.out.println("\n Previous order");
        for (Service s : manager.getPreviousOrders()) {
            System.out.println("- " + s.getName() + " (₹" + s.getPrice() + ")");
        }
    }
}