package Bakery.Foods.Sandwich;

public class BasicSandwich implements Sandwich //blank Sandwich class to use the decorator on
{
    @Override
    public double getCost() {
        return 2.00;
    }
}
