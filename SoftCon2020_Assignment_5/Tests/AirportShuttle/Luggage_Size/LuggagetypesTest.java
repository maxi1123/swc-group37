package AirportShuttle.Luggage_Size;

import AirportShuttle.Cars.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuggagetypesTest {

    @Test
    void luggage_size_Small() {
        Car car = new Micro_Car();
        assertEquals(car.getluggagesize(),1 );
    }

    @Test
    void luggage_size_Medium() {
        Car car = new Supercar();
        assertEquals(car.getluggagesize(),2 );
    }

    @Test
    void luggage_size_Big() {
        Car car = new Family_Car();
        assertEquals(car.getluggagesize(),4 );
    }

    @Test
    void luggage_size_Nolimit() {
        Car car = new Bus();
        assertEquals(car.getluggagesize(), 1000);
    }
}