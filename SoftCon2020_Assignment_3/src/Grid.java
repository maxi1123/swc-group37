import boats.*;

import java.util.ArrayList;
import java.util.Random;

public class Grid implements Gridable{
    private final int columns = 10;
    private final int rows = 10;

    String[][] grid = new String[columns][rows];

    // Method responsible for building a near-empty grid. All the fields in a 10x10 grid are set to [ ].

    @Override
    public void buildGrid(){
        for(int column=0; column<columns; column++){
            for(int row=0; row<rows; row++){
                grid[column][row] = "[ ]";
            }
        }
    }

    public void placeAI(){

        ArrayList<Ship> AIList = new ArrayList<>();

        // Loop for populating ArrayList<Ship> shipList with all available ships.

        int count = 1;

        for (int j=0; j<10; j++){

            if(j==0){
                Carrier AICarrier = new Carrier();
                AIList.add(AICarrier);
                continue;
            }
            else if(j>0 && j<3){
                Battleship AIBattleship = new Battleship("Battleship " + count);
                AIList.add(AIBattleship);
                count++;
            }
            else if(j>2 && j<6){
                if(j==3){
                    count = 1;
                }
                Submarine AISubmarine = new Submarine("Submarine " + count);
                AIList.add(AISubmarine);
                count++;
            }
            else{
                if(j==6){
                    count = 1;
                }
                PatrolBoat AIPatrolBoat = new PatrolBoat("Patrol boat " + count);
                AIList.add(AIPatrolBoat);
                count++;
            }
        }

        for(int i=0; i<10; i++){
            int horizontal = 0;
            int vertical = 1;
            int random = Randomizer.getRandomNumberInRange(horizontal, vertical);
            int SIZEOFSHIP = AIList.get(i).getSize();
            
            if(random == 0){
                int coord_one = Randomizer.getRandomNumberInRange(0, 9);
                int coord_two = Randomizer.getRandomNumberInRange(0, 9);
            }
        }
    }

    // Method responsible for printing the final grid. Gets called once in Main.java.

    @Override
    public void printGrid(){
        for(int row = 0; row < rows; row++){
            System.out.print("\n");
            if(row==0){
                char row_char='A';
                System.out.print("   |");
                for(int i=0; i<rows; i++){
                    System.out.print("[" + row_char + "]");
                    row_char++;
                }
                System.out.print("\n");
                System.out.print("---|");
                for(int i=0; i<rows;i++){
                    System.out.print("---");
                }
                System.out.print("\n");
            }

            for(int column = 0; column < columns; column++){
                if (column==0){System.out.print("["+row+"]|");}
                System.out.print(grid[row][column]);
            }
        }
    }

    // Method responsible for inserting a ship in a given position. Implemented in Validator.InputValidate.

    @Override
    public void Insert(Ship ship, String start,String end){
        if(start.charAt(0)==end.charAt(0)){
            for(int i = 0;i < ship.getSize(); i++){
                grid[start.charAt(1)+i-'0'][start.charAt(0)-'A'] = "["+ ship.getType() +"]";
            }
        }
        else{
            for(int i = 0;i < ship.getSize(); i++){
                grid[start.charAt(1)-'0'][start.charAt(0)-'A'+i] = "["+ ship.getType() +"]";

            }
        }
    }
}
