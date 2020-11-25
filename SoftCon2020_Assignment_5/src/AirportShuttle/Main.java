package AirportShuttle;

import AirportShuttle.Cars.Car;
import AirportShuttle.Cars.Family_Car;
import AirportShuttle.Cars.Micro_Car;
import AirportShuttle.Cars.Supercar;
import AirportShuttle.Customer.Customer;


public class Main {
    public static void main(String[] args) {
        Car car = new Supercar();
        Customer customer = new Customer(car);
        customer.printfunction(Customer.ride());
    }
}