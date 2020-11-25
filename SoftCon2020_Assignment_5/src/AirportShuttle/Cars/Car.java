package AirportShuttle.Cars;

import AirportShuttle.GasolineTypes.DifferentGasolinetypes;
import AirportShuttle.Pricetypes.Costs;
import AirportShuttle.Luggage_Size.Luggagetypes;
import AirportShuttle.Speedtypes.Different_Speeds;

public class Car {
    protected Costs pricetype;
    protected Luggagetypes luggagetype;
    protected Different_Speeds speed;
    protected DifferentGasolinetypes gasolinetype;
    protected String name;


    public int getpricetype(){
        return pricetype.price();
    }
    public String getluggagesize(){
        return luggagetype.luggage_size();
    }
    public String getspeed(){
        return speed.speed();
    }
    public String getGasolinetype(){
        return gasolinetype.Gasolinetype();
    }
    public String getName(){return name;}


    public void setPricetype(Costs newPriceType){
        pricetype = newPriceType;
    }
    public void setLuggagetype(Luggagetypes newLuggagetype){ luggagetype = newLuggagetype; }
    public void setSpeedtype(Different_Speeds newSpeedtype){
        speed = newSpeedtype;
    }
    public void setGasolinetype(DifferentGasolinetypes newGasolinetype){ gasolinetype = newGasolinetype; }
}

