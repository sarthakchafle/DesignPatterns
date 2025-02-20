package FactoryDesignPattern.Pizzas;

public class VeggiePizza implements Pizza {
    @Override
    public String prepare() {
        return "Preparing Veggie Pizza";
    }
}
