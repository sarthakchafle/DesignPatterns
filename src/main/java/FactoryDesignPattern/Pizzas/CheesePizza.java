package FactoryDesignPattern.Pizzas;

public class CheesePizza implements Pizza {
    @Override
    public String prepare() {
        return "Preparing Cheese Pizza!";
    }
}
