package DecoratorDesignPattern;

public class Sugar extends CoffeeDecorator{
    public Sugar(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }
    @Override
    public double cost() {
        return super.cost() + 0.5; // Sugar costs $0.5
    }

    @Override
    public String description() {
        return super.description() + ", Sugar";
    }
}
