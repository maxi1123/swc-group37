import boats.*;

import java.util.ArrayList;

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

    public ArrayList<Ship> generateAIFleet(){

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
        return AIList;
    }

    public void placeAI(ArrayList<Ship> AIList, int count, Grid ai_grid_hidden){
        final int horizontal = 0;
        final int vertical = 1;
        while(count<10){
            int random = Randomizer.getRandomNumberInRange(horizontal, vertical);
            int SIZEOFSHIP = AIList.get(count).getSize();

            if(random == 0){
                int c1_one, c1_two, c2_one, c2_two;

                // Row

                c1_one = Randomizer.getRandomNumberInRange(0, 9);
                c2_one = c1_one;

                // Column (if horizontal, row coordinates stay the same)

                c1_two = Randomizer.getRandomNumberInRange(0, 9);

                // Placement from right to left

                if (c1_two - (SIZEOFSHIP-1) >= 0){
                    for (int i = c1_two; i>c1_two-SIZEOFSHIP; i--){
                        if(ai_grid_hidden.grid[c1_one][i] == "[ ]"){
                            AIList.get(count).updateCoordlist(c1_one, i);
                            continue;
                        }
                        else{
                            int length = AIList.get(count).getCoordlength();
                            if(length>0){
                                for (int j = length-1; j>=0; j--){
                                    AIList.get(count).getCoordlist().remove(j);
                                }
                            }
                            placeAI(AIList, count, ai_grid_hidden);
                            return;
                        }
                    }
                    // Insert(AIList.get(count),Transformer.IntToStringTransform1(c1_one-(SIZEOFSHIP-1), c1_two), Transformer.IntToStringTransform1(c1_one, c2_two));
                    int check = 0;
                    insertAI(AIList.get(count), c1_one, c1_two, check, ai_grid_hidden);
                    count++;
                }

                // Placement from left to right

                else{
                    if (c1_two + (SIZEOFSHIP-1) <= 9){
                        for (int i = c1_two; i<c1_two+SIZEOFSHIP; i++){
                            if(ai_grid_hidden.grid[c1_one][i] == "[ ]"){
                                AIList.get(count).updateCoordlist(c1_one, i);
                                continue;
                            }
                            else{
                                int length = AIList.get(count).getCoordlength();
                                if(length>0){
                                    for (int j = length-1; j>=0; j--){
                                        AIList.get(count).getCoordlist().remove(j);
                                    }
                                }
                                placeAI(AIList, count, ai_grid_hidden);
                                return;
                            }
                        }
                        //Insert(AIList.get(count), Transformer.IntToStringTransform1(c1_one, c1_two), Transformer.IntToStringTransform1(c1_one + (SIZEOFSHIP-1), c2_two));
                        int check = 1;
                        insertAI(AIList.get(count), c1_one, c1_two, check, ai_grid_hidden);
                        count++;

                    }
                    else{
                        placeAI(AIList, count, ai_grid_hidden);
                        return;
                    }

                }

            }


            if(random == 1){
                int c1_one, c1_two, c2_one, c2_two;

                // Row

                c1_two = Randomizer.getRandomNumberInRange(0, 9);
                c2_two = c1_two;

                // Column (if horizontal, row coordinates stay the same)

                c1_one = Randomizer.getRandomNumberInRange(0, 9);

                // Placement from top downwards

                if (c1_one + (SIZEOFSHIP-1) <= 9){
                    for (int i = c1_one; i<c1_one+SIZEOFSHIP; i++){
                        if(ai_grid_hidden.grid[i][c1_two] == "[ ]"){
                            AIList.get(count).updateCoordlist(i, c1_two);
                            continue;
                        }
                        else{
                            int length = AIList.get(count).getCoordlength();
                            if(length>0){
                                for (int j = length-1; j>=0; j--){
                                    AIList.get(count).getCoordlist().remove(j);
                                }
                            }
                            placeAI(AIList, count, ai_grid_hidden);
                            return;
                        }
                    }
                    // Insert(AIList.get(count), Transformer.IntToStringTransform1(c1_one, c1_two), Transformer.IntToStringTransform1(c2_one, c1_two + (SIZEOFSHIP-1)));
                    int check = 2;
                    insertAI(AIList.get(count), c1_one, c1_two, check, ai_grid_hidden);
                    count++;
                }

                // Placement from bottom to top

                else{
                    if (c1_one - (SIZEOFSHIP-1) >= 0){
                        for (int i = c1_one; i>c1_one-SIZEOFSHIP; i--){
                            if(ai_grid_hidden.grid[i][c1_two] == "[ ]"){
                                AIList.get(count).updateCoordlist(i, c1_two);
                                continue;
                            }
                            else{
                                int length = AIList.get(count).getCoordlength();
                                if(length>0){
                                    for (int j = length-1; j>=0; j--){
                                        AIList.get(count).getCoordlist().remove(j);
                                    }
                                }
                                placeAI(AIList, count, ai_grid_hidden);
                                return;
                            }
                        }
                        // Insert(AIList.get(count), Transformer.IntToStringTransform1(c1_one, c1_two - (SIZEOFSHIP-1)), Transformer.IntToStringTransform1(c2_one, c1_two));
                        int check = 3;
                        insertAI(AIList.get(count), c1_one, c1_two, check, ai_grid_hidden);
                        count++;

                    }
                    else{
                        placeAI(AIList, count, ai_grid_hidden);
                        return;
                    }
                }
            }
        }
    }

    public void insertAI(Ship ship, int start, int end, int check, Grid ai_grid_hidden){
        // Right to left
        if (check == 0){
            for (int i = end; i>end - ship.getSize(); i--){
                ai_grid_hidden.grid[start][i] = "[" + ship.getType() + "]";
            }
        }
        if (check == 1){
            for (int i = end; i<end + ship.getSize(); i++){
                ai_grid_hidden.grid[start][i] = "[" + ship.getType() + "]";
            }

        }
        if (check == 2){
            for (int i = start; i<start + ship.getSize(); i++){
                ai_grid_hidden.grid[i][end] = "[" + ship.getType() + "]";
            }
        }
        if (check == 3){
            for (int i = start; i>start - ship.getSize(); i--){
                ai_grid_hidden.grid[i][end] = "[" + ship.getType() + "]";
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
                ship.updateCoordlist(start.charAt(1)+i-'0',start.charAt(0)-'A');
            }
        }
        else{
            for(int i = 0;i < ship.getSize(); i++){
                grid[start.charAt(1)-'0'][start.charAt(0)-'A'+i] = "["+ ship.getType() +"]";
                ship.updateCoordlist(start.charAt(1)-'0',start.charAt(0)-'A'+i);

            }
        }
    }
}
