package Bakery.Foods.Cake;

public class Cream extends CakeDecorator{
    public Cream(Cake cake) {
        super(cake);
    }

    @Override
    public double getCost() {
        return TempCake.getCost() + 1.50;
    }
}
