package Bakery;
import java.util.*;

public class CentralOffice extends Entity{
    private ArrayList<Entity> CityOfficeList = new ArrayList<Entity>();

    public void printAllOffices(){

    }
    @Override
    public void add(Entity entity) {
        CityOfficeList.add(entity);
    }
    @Override
    public void remove(Entity entity) {

        CityOfficeList.remove(entity);
    }
    public void print(){
        Iterator<Entity> CofficeIterator = CityOfficeList.iterator();
        while(CofficeIterator.hasNext()){
            CofficeIterator.next().print();
        }
    }

}
