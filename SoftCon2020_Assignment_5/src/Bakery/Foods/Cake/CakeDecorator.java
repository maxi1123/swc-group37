package Bakery.Foods.Cake;

public class CakeDecorator implements Cake //Decorator superclass from which each ingredient extends
{

    protected Cake TempCake;

    public CakeDecorator(Cake cake){
        TempCake = cake;
    }
    @Override
    public double getCost() {
        return TempCake.getCost();
    }
}
