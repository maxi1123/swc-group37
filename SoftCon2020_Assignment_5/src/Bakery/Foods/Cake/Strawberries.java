package Bakery.Foods.Cake;

public class Strawberries extends CakeDecorator {
    public Strawberries(Cake cake) {
        super(cake);
    }

    @Override
    public double getCost() {
        return TempCake.getCost() + 1.00;
    }
}
