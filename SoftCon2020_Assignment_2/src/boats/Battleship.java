package boats;

public class Battleship implements Ship{

    private final int size = 4;
    private final char type = 'B';
    static String fullname;
    private final int allowed = 2;

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

    public void setName(String name){
        this.fullname = name;
    }
}
