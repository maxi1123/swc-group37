package Bakery.Foods.Sandwich;

public class SandwichDecorator implements Sandwich //decorator class for sandwiches, from which each ingredient extends
{
    protected Sandwich TempSandwich;

    public SandwichDecorator(Sandwich sandwich){
        TempSandwich = sandwich;
    }

    @Override
    public double getCost() {
        return TempSandwich.getCost();
    }
}
