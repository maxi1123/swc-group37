package AirportShuttle.Cars;

import AirportShuttle.GasolineTypes.Diesel;
import AirportShuttle.Speedtypes.*;
import AirportShuttle.Luggage_Size.big;
import AirportShuttle.Pricetypes.Cheapest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BusTest {

    @org.junit.jupiter.api.Test
    void getpricetype() {
        Car car = new Bus();
        assertEquals(car.getpricetype(), 5);
    }


    @org.junit.jupiter.api.Test
    void getluggagesize() {
        Car car = new Family_Car();
        assertEquals(car.getluggagesize(), 4);
    }

    @org.junit.jupiter.api.Test
    void getspeed() {
        Car car = new Micro_Car();
        assertEquals(car.getspeed(), "Normal");
    }

    @org.junit.jupiter.api.Test
    void getGasolinetype() {
        Car car = new Supercar();
        assertEquals(car.getGasolinetype(), "Gasoline" );
    }

    @Test
    void setPricetype() {
        Car car = new Supercar();
        car.setPricetype(new Cheapest());
        assertEquals(car.getpricetype(),5 );
    }

    @Test
    void setLuggagetype() {
        Car car = new Supercar();
        car.setLuggagetype(new big());
        assertEquals(car.getluggagesize(),4 );
    }

    @Test
    void setSpeedtype() {
        Car car = new Supercar();
        car.setSpeedtype(new slow());
        assertEquals(car.getspeed(),"Slow");
    }

    @Test
    void setGasolinetype() {
        Car car = new Supercar();
        car.setGasolinetype(new Diesel());
        assertEquals(car.getGasolinetype(),"Diesel");
    }

}