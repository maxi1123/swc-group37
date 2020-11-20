package AirportShuttle.Cars;

import AirportShuttle.GasolineTypes.Gasoline;
import AirportShuttle.Pricetypes.expensive;
import AirportShuttle.Luggage_Size.medium;
import AirportShuttle.Speedtypes.fast;

public class Supercar extends Car{
    public Supercar(){
        super();
        pricetype = new expensive();
        luggagetype = new medium();
        speed = new fast();
        gasolinetype = new Gasoline();
    }
}
