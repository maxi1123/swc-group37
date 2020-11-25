package AirportShuttle.Pricetypes;

import AirportShuttle.Cars.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CostsTest {

    @Test
    void pricecheapest() {
        Car car = new Bus();
        assertEquals(car.getpricetype(), 5);
    }

    @Test
    void pricecheap() {
        Car car = new Micro_Car();
        assertEquals(car.getpricetype(), 12);
    }

    @Test
    void pricemiddle() {
        Car car = new Family_Car();
        assertEquals(car.getpricetype(), 15);
    }

    @Test
    void priceexpensive() {
        Car car = new Supercar();
        assertEquals(car.getpricetype(), 30);
    }
}