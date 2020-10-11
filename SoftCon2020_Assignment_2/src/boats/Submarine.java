package boats;

public class Submarine implements Ship{
    private final int size = 3;
    private final char type = 'S';
    static String fullname;
    private final int allowed = 3;

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
