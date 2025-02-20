package FactoryDesignPattern.Pizzas;

public class PepperoniPizza implements Pizza {

    @Override
    public String prepare() {
        return "Preparing Pepperoni Pizza";
    }
}
