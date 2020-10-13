package boats;

public class Submarine implements Ship{

    private final int size = 3;
    private final char type = 'S';
    private String fullname;

    public Submarine(String shipname){
        this.fullname = shipname;
    }

    @Override
    public int getSize(){
        return size;
    }
    @Override
    public char getType(){
        return type;
    }
    @Override
    public String getName(){ return fullname; }

    public void setName(String name){ fullname = name; }
}
