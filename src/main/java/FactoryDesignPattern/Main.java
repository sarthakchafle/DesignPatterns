package FactoryDesignPattern;

import FactoryDesignPattern.Factory.PizzaFactory;
import FactoryDesignPattern.Factory.PizzaFactoryImpl;
import FactoryDesignPattern.Pizzas.Pizza;

public class Main {
    public static void main(String[] args) {
        try {
            String userInput = "Veggie";
            PizzaFactory pizzaFactory = new PizzaFactoryImpl();
            Pizza p = pizzaFactory.createPizza(userInput);
            System.out.println(p.prepare());
        }
        catch (Exception e){
            System.out.println("No such Pizza!");
        }
    }
}
