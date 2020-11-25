package Bakery.Franchise;

public abstract class Entity //Entity is the component of every office and bakery in this composite
{
    String name;

    public void add(Entity entity){
        throw new UnsupportedOperationException();
    }
    public void remove(Entity entity){
        throw new UnsupportedOperationException();
    }
    public void print(){
        throw new UnsupportedOperationException();
    }
}
