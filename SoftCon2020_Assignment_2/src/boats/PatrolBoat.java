package boats;

public class PatrolBoat implements Ship {

    private final int size = 2;
    private final char type = 'P';
    static String fullname;
    private final int allowed = 4;

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
