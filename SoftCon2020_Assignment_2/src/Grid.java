import boats.*;

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
