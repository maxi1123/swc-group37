package Bakery.Foods.Cake;

public class Chocolate extends CakeDecorator{
    public Chocolate(Cake cake) {
        super(cake);
    }

    @Override
    public double getCost() {
        return TempCake.getCost() + 2.00;
    }
}
