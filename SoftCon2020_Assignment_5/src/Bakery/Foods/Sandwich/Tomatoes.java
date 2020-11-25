package Bakery.Foods.Sandwich;

public class Tomatoes extends SandwichDecorator //Decorator ingredient
{
    public Tomatoes(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public double getCost() {
        return TempSandwich.getCost() + 1.50;
    }
}
