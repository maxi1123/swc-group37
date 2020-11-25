package AirportShuttle.Cars;

import AirportShuttle.GasolineTypes.Diesel;
import AirportShuttle.Luggage_Size.NoLimit;
import AirportShuttle.Pricetypes.Cheapest;
import AirportShuttle.Speedtypes.slow;

public class Bus extends Car {
    public Bus(){
        super();
        pricetype = new Cheapest();
        luggagetype = new NoLimit();
        speed = new slow();
        gasolinetype = new Diesel();
    }
}
