package Bakery.Foods.Sandwich;

public class SandwichDecorator implements Sandwich{
    protected Sandwich TempSandwich;

    public SandwichDecorator(Sandwich sandwich){
        TempSandwich = sandwich;
    }

    @Override
    public double getCost() {
        return TempSandwich.getCost();
    }
}
