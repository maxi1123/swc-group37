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
                System.out.print("[" + grid[column][row] + "]");
            }
        }
    }
}
