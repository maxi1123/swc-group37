package boats;
import java.util.ArrayList;

public class Carrier implements Ship{

    private final int size = 6;
    private final char type = 'C';
    private final String fullname = "Carrier";
    private final int allowed = 1;
    private ArrayList<String> coordlist = new ArrayList<>();

    public void updateCoordlist(int coordOne, int coordTwo){
        coordlist.add("" + coordOne + coordTwo);
    }
    public int getCoordlength(){
        return coordlist.size();
    }
    public ArrayList<String> getCoordlist(){
        return coordlist;
    }
    public void replaceCoordlist(ArrayList<String> coordlist){
        this.coordlist = coordlist;
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
