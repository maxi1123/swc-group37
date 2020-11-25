package Bakery.Foods.Cake;

public class BasicCake implements Cake //blank cake class to use the decorator on
{

    @Override
    public double getCost() {
        return 3.00;
    }
}
