package boats;

import java.util.ArrayList;

public class Submarine implements Ship{

    private final int size = 3;
    private final char type = 'S';
    private String fullname;
    private ArrayList<String> coordlist = new ArrayList<>();

    public Submarine(String shipname){
        fullname = shipname;
    }

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
    public char getType(){return type;}
    @Override
    public String getName(){ return fullname; }
}
