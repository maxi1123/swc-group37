import boats.*;

public class Grid {
    private static final int columns = 10;
    private static final int rows = 10;

    static String[][] grid = new String[columns][rows];

    public void buildGrid(){
        for(int column=0; column<columns; column++){
            for(int row=0; row<rows; row++){
                grid[column][row] = "[]";
            }
        }
    }
    public void placeShip(Ship ship, char start, char end){

    }
}
