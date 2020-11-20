package AirportShuttle.Cars;

import AirportShuttle.GasolineTypes.Gasoline;
import AirportShuttle.Pricetypes.middle;
import AirportShuttle.Luggage_Size.big;
import AirportShuttle.Speedtypes.normal;

public class Family_Car extends Car {
    public Family_Car(){
        super();
        pricetype = new middle();
        luggagetype = new big();
        speed = new normal();
        gasolinetype = new Gasoline();
    }

}
