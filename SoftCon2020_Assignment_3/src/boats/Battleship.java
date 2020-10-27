package boats;

public class Battleship implements Ship{

    private final int size = 4;
    private final char type = 'B';
    private String fullname;

    public Battleship(String shipname){
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
