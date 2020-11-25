package AirportShuttle.Cars;

import AirportShuttle.GasolineTypes.Electric;
import AirportShuttle.Pricetypes.*;
import AirportShuttle.Luggage_Size.small;
import AirportShuttle.Speedtypes.normal;

public class Micro_Car extends Car {
    public Micro_Car(){
        super();
        pricetype = new cheap();
        luggagetype = new small();
        speed = new normal();
        gasolinetype = new Electric();
        name = "Micro Car";
    }

}
