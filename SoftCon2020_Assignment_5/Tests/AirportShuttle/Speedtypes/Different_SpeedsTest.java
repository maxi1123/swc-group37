package AirportShuttle.Speedtypes;

import AirportShuttle.Cars.Bus;
import AirportShuttle.Cars.Car;
import AirportShuttle.Cars.Family_Car;
import AirportShuttle.Cars.Supercar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Different_SpeedsTest {

    @Test
    void speedslow() {
        Car car = new Bus();
        assertEquals(car.getspeed(), "Slow");
    }

    @Test
    void speednormal() {
        Car car = new Family_Car();
        assertEquals(car.getspeed(), "Normal");
    }

    @Test
    void speedfast() {
        Car car = new Supercar();
        assertEquals(car.getspeed(), "Fast");
    }

}