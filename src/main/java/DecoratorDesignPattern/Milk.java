package DecoratorDesignPattern;

public class Milk extends CoffeeDecorator{
    public Milk(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }
    @Override
    public double cost() {
        return super.cost() + 1.5; // Milk costs $1.5
    }

    @Override
    public String description() {
        return super.description() + ", Milk";
    }
}
