package boats;

public class PatrolBoat implements Ship {

    private final int size = 2;
    private final char type = 'P';
    private String fullname;

    public PatrolBoat(String shipname){
        fullname = shipname;
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
}
