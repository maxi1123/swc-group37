package boats;

import java.util.ArrayList;

public class Battleship implements Ship{

    private final int size = 4;
    private final char type = 'B';
    private String fullname;
    private ArrayList<String> coordlist = new ArrayList<>();

    public Battleship(String shipname){
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
    public char getType(){
        return type;
    }
    @Override
    public String getName(){ return fullname; }
}
