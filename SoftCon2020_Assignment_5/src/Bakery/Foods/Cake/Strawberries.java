package Bakery.Foods.Cake;

public class Strawberries extends CakeDecorator //Decorator ingredient
{
    public Strawberries(Cake cake) {
        super(cake);
    }

    @Override
    public double getCost() {
        return TempCake.getCost() + 1.00;
    }
}
