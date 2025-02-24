package DecoratorDesignPattern;

public class SimpleCoffee implements Coffee{

    @Override
    public double cost() {
        return 5.0;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}
