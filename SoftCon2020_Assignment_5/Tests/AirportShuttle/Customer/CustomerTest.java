package AirportShuttle.Customer;

import AirportShuttle.Cars.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void TestgetCarMicro() {
        Car car = new Micro_Car();
        Customer customer = new Customer(car);
        assertEquals(customer.getCar() instanceof Micro_Car, car instanceof Micro_Car );
    }

    @Test
    void TestgetCarSuper() {
        Car car = new Supercar();
        Customer customer = new Customer(car);
        assertEquals(customer.getCar() instanceof Supercar, car instanceof Supercar);
    }

    @Test
    void TestgetCarFamily() {
        Car car = new Family_Car();
        Customer customer = new Customer(car);
        assertEquals(customer.getCar() instanceof Family_Car, car instanceof Family_Car);
    }

    @Test
    void TestgetCarBus() {
        Car car = new Bus();
        Customer customer = new Customer(car);
        assertEquals(customer.getCar() instanceof Bus, car instanceof Bus);
    }

    @Test
    void Testride() {
        Car car = new Bus();
        Customer customer = new Customer(car);
        assertEquals(customer.ride(), Customer.car.getName() + "; " + Customer.car.getluggagesize() + "; " + Customer.car.getspeed() + " Speed; " + Customer.car.getpricetype() + "CHF/h" );
    }
}