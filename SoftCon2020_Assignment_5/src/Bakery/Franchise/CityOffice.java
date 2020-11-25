package Bakery.Franchise;
import java.util.ArrayList;
import java.util.Iterator;

public class CityOffice extends Entity //entites on the second level of the composite tree
{
    public CityOffice(String city){
        this.name = "city office of " + city;
    }

    ArrayList<Entity> BakeryList = new ArrayList<Entity>();

    public void print(){
        System.out.println(name);
        Iterator<Entity> BakeryIterator = BakeryList.iterator();
        while(BakeryIterator.hasNext()){
            BakeryIterator.next().print();
        }
    }

    @Override
    public void add(Entity entity) {
        BakeryList.add(entity);
    }

    @Override
    public void remove(Entity entity) {
        BakeryList.add(entity);
    }
    public void printAllBakeriesNames(){
        print();
    }

}
