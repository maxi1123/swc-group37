package AirportShuttle;

import AirportShuttle.Cars.Car;
import AirportShuttle.Cars.Family_Car;
import AirportShuttle.Cars.Micro_Car;


public class Main {
    public static void main(String[] args) {

        Car car = new Family_Car();
        System.out.println(car.getpricetype());

    }
}