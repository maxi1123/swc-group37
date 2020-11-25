package Bakery.Franchise;

public abstract class Bakery extends Entity //basic structure for the bakeries which will be the leaves of this composite
{
    String name;
    String address;

    public void print(){
        System.out.println(name);
    }

    public String getName(){
        return name;
    }

    public void printName(){
        print();
    }
}
