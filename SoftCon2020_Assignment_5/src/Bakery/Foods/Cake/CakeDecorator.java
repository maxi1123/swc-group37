package Bakery.Foods.Cake;

public class CakeDecorator implements Cake{

    protected Cake TempCake;

    public CakeDecorator(Cake cake){
        TempCake = cake;
    }
    @Override
    public double getCost() {
        return TempCake.getCost();
    }
}
