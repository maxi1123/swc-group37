package Bakery.Franchise;

public abstract class Bakery extends Entity {
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
