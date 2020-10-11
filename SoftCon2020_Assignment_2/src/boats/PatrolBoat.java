package boats;

public class PatrolBoat implements Ship {

    private final int size = 2;
    private final char type = 'P';
    private final int allowed = 4;

    @Override
    public int getSize(){
        return size;
    }
    @Override
    public char getType(){
        return type;
    }

}
