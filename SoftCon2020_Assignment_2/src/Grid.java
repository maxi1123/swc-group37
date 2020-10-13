import boats.*;

public class Grid {
    private final int columns = 10;
    private final int rows = 10;

    String[][] grid = new String[columns][rows];

    public void buildGrid(){
        for(int column=0; column<columns; column++){
            for(int row=0; row<rows; row++){
                grid[column][row] = "[ ]";
            }
        }
    }
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
    public void Insert(Ship ship, String start,String end, Grid grid){
        if(start.charAt(0)==end.charAt(0)){
            for(int i = 0;i < ship.getSize(); i++){
                grid.grid[start.charAt(1)+i-'0'][start.charAt(0)-'A'] = "["+ ship.getType() +"]";
            }
        }
        else{
            for(int i = 0;i < ship.getSize(); i++){
                grid.grid[start.charAt(1)-'0'][start.charAt(0)-'A'+i] = "["+ ship.getType() +"]";

            }
        }
    }
}
