package FactoryDesignPattern.Factory;

import FactoryDesignPattern.Pizzas.Pizza;
import FactoryDesignPattern.Pizzas.CheesePizza;
import FactoryDesignPattern.Pizzas.PepperoniPizza;
import FactoryDesignPattern.Pizzas.VeggiePizza;

public class PizzaFactoryImpl implements PizzaFactory {
    @Override
    public Pizza createPizza(String pizzaType) {
        switch (pizzaType){
            case "Pepperoni":
                return new PepperoniPizza();
            case "Cheese":
                return new CheesePizza();
            case "Veggie":
                return new VeggiePizza();
            default:
                return null;
        }
    }
}
