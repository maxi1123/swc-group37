package Bakery.Foods.Sandwich;

public class Ham extends SandwichDecorator{
    public Ham(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public double getCost() {
        return TempSandwich.getCost() + 2.00;
    }
}
