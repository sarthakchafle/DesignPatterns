package DecoratorDesignPattern;

public class CoffeeShopMain {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.description() + " -> $" + coffee.cost());

        coffee = new Milk(coffee);
        System.out.println(coffee.description() + " -> $" + coffee.cost());

        // Coffee with Milk and Sugar
        coffee = new Sugar(coffee);
        System.out.println(coffee.description() + " -> $" + coffee.cost());
    }
}
