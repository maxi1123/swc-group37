package boats;

public class Carrier implements Ship{

    private final int size = 6;
    private final char type = 'C';
    private final int allowed = 1;

    @Override
    public int getSize(){
        return size;
    }
    @Override
    public char getType(){
        return type;
    }
}
