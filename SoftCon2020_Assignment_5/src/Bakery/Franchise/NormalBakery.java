package Bakery.Franchise;

import Bakery.Foods.Cake.*;
import Bakery.Foods.Sandwich.*;

import java.util.ArrayList;

public class NormalBakery extends Bakery //one type of leaf for the composite
{
    public NormalBakery(String name, String address) {
        this.name = name;
        this.address = address;
    }

    ArrayList<Sandwich> sandwiches = new ArrayList<Sandwich>();

    public void newSandwich() {
        if (sandwiches.isEmpty()) {
            sandwiches.add(new BasicSandwich());
        } else {
            System.out.println("Sandwich creation in progress! Check this one out first.");
        }
    }

    public void addHam() {
        if (sandwiches.size() == 1) {
            Ham x = new Ham(sandwiches.get(0));
            sandwiches.remove(0);
            sandwiches.add(x);
        }
    }

    public void addCheese() {
        if (sandwiches.size() == 1) {
            Cheese x = new Cheese(sandwiches.get(0));
            sandwiches.remove(0);
            sandwiches.add(x);
        }
    }

    public void addTomatoes() {
        if (sandwiches.size() == 1) {
            Tomatoes x = new Tomatoes(sandwiches.get(0));
            sandwiches.remove(0);
            sandwiches.add(x);
        }
    }

    public void addTuna() {
        if (sandwiches.size() == 1) {
            Tuna x = new Tuna(sandwiches.get(0));
            sandwiches.remove(0);
            sandwiches.add(x);
        }
    }

    public void checkoutSandwich() {
        System.out.println("Your Sandwich costs " + sandwiches.get(0).getCost() + " CHF");
        sandwiches.clear();
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
