package Zomato;

//Decorator
public class ExtraCheese implements MenuItem{
    private MenuItem basicItem;

    public ExtraCheese(MenuItem basicItem) {
        this.basicItem = basicItem;
    }

    @Override
    public String getDescription() {
        return basicItem.getDescription();
    }

    @Override
    public double getPrice() {
        return basicItem.getPrice()+20;
    }
}
