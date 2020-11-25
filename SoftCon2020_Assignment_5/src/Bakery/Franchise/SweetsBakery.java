package Bakery.Franchise;

import Bakery.Foods.Cake.*;

import java.util.ArrayList;

public class SweetsBakery extends Bakery //one type of leaf for the composite
{
    public SweetsBakery(String name, String address){
        this.name = name;
        this.address = address;
    }
    ArrayList<Cake> cakes = new ArrayList<Cake>();

    public void newCake() {
        if (cakes.isEmpty()) {
            cakes.add(new BasicCake());
        } else {
            System.out.println("Cake creation in progress! Check this one out first.");
        }
    }

    public void addStrawberries() {
        if (cakes.size() == 1) {
            Strawberries x = new Strawberries(cakes.get(0));
            cakes.remove(0);
            cakes.add(x);
        }

    }
    public void addChocolate() {
        if (cakes.size() == 1) {
            Chocolate x = new Chocolate(cakes.get(0));
            cakes.remove(0);
            cakes.add(x);
        }

    }
    public void addCream() {
        if (cakes.size() == 1) {
            Cream x = new Cream(cakes.get(0));
            cakes.remove(0);
            cakes.add(x);
        }

    }
    public void checkoutCake() {
        System.out.println("Your Cake costs " + cakes.get(0).getCost() + " CHF");
        cakes.clear();
    }
}
