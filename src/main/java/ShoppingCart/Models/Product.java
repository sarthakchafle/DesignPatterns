package ShoppingCart.Models;

import ShoppingCart.Models.Category;

public class Product {
    private String name;
    private Category category;
    private double price;

    public Product(String name, Category category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
