package boats;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Carrier implements Ship{

    private final int size = 6;
    private final char type = 'C';
    private final String fullname = "Carrier";
    private final int allowed = 1;
    private ArrayList<String> coordlist = new ArrayList<>();
    private ArrayList<String> backup = new ArrayList<>();

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
    public void copyCoordlist(){
        for (int i=0; i<coordlist.size(); i++){
            backup.add(coordlist.get(i));
        }
    }
    public ArrayList<String> getBackup(){
        return backup;
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
