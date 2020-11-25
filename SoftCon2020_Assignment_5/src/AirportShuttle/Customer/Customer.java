package AirportShuttle.Customer;

import AirportShuttle.Cars.*;

public class Customer {
    protected static Car car;

    public Customer(Car chosencar){
        if (chosencar instanceof Micro_Car){
            this.car = new Micro_Car();
        }
        if (chosencar instanceof Supercar){
            this.car = new Supercar();
        }
        if (chosencar instanceof Bus){
            this.car = new Bus();
        }
        if (chosencar instanceof Family_Car){
            this.car = new Family_Car();
        }
    }

    public Car getCar(){
        return car;
    }
     static public String ride(){
        return (Customer.car.getName() + "; " + Customer.car.getluggagesize() + "; " + Customer.car.getspeed() + " Speed; " + Customer.car.getpricetype() + "CHF/h" );
     }

    public static void printfunction(String ride){
        System.out.println(ride);
    }
}
