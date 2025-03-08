package Zomato;

import java.util.ArrayList;
import java.util.List;

public class Cart{
    private List<MenuItem> items = new ArrayList<>();
    public void addItem(MenuItem menuItem){
        items.add(menuItem);
        System.out.println(menuItem.getDescription()+" added to cart");
    }
    public List<MenuItem> getItems(){
        return items;
    }
    public void clearCart(){
        items.clear();
        System.out.println("Cart has been cleared");
    }
}
