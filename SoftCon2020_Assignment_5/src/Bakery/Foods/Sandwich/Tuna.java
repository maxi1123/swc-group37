package Bakery.Foods.Sandwich;

public class Tuna extends SandwichDecorator //Decorator ingredient
{
    public Tuna(Sandwich sandwich) {
        super(sandwich);
    }
    @Override
    public double getCost() {
        return TempSandwich.getCost() + 3.00;
    }
}
