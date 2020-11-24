package Bakery.Foods.Sandwich;

public class Cheese extends SandwichDecorator{
    public Cheese(Sandwich sandwich) {
        super(sandwich);
    }
    @Override
    public double getCost() {
        return TempSandwich.getCost() + 1.00;
    }
}
