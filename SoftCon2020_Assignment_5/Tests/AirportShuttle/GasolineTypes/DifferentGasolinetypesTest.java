package AirportShuttle.GasolineTypes;

import AirportShuttle.Cars.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifferentGasolinetypesTest {

    @Test
    void TestDiesel() {
        Car car = new Bus();
        assertEquals(car.getGasolinetype(), "Diesel");
    }

    @Test
    void TestGasoline() {
        Car car = new Family_Car();
        assertEquals(car.getGasolinetype(), "Gasoline");
    }

    @Test
    void TestElectric() {
        Car car = new Micro_Car();
        assertEquals(car.getGasolinetype(), "Electric");
    }
}