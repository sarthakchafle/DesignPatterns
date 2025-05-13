package Zomato;

import java.util.List;

public class RestaurantFactory {
    public static Restaurant createRestaurant(String name, List<MenuItem> menu, RestaurantOwner owner) {
        return new Restaurant(name, menu, owner);
    }
}
