package Zomato;

import java.util.List;

public class Restaurant {
    private String name;
    private List<MenuItem> menu;
    private RestaurantOwner owner;

    public Restaurant(String name, List<MenuItem> menu, RestaurantOwner owner) {
        this.name = name;
        this.menu = menu;
        this.owner = owner;
    }
    public void displayMenu(){
        System.out.println("Menu for "+name+ ": ");
        for(MenuItem menuItem: menu){
            System.out.println(menuItem.getDescription() + "-  "+ menuItem.getPrice()+" Rs.");
        }
    }
}
