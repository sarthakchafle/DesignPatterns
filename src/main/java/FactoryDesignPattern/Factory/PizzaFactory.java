package FactoryDesignPattern.Factory;

import FactoryDesignPattern.Pizzas.Pizza;

public interface PizzaFactory {
    Pizza createPizza(String pizzaType);
}
