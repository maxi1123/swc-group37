import boats.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to Battleship!!");
        Grid player_grid = new Grid();
        player_grid.buildGrid();
        Grid ai_grid = new Grid();
        ai_grid.buildGrid();

        ArrayList<Ship> shipList = new ArrayList<>();

        // Loop for populating ArrayList<Ship> shipList with all available ships.

        int count = 1;

        for (int j=0; j<10; j++){

            if(j==0){
                Carrier carrier = new Carrier();
                shipList.add(carrier);
                continue;
            }
            else if(j>0 && j<3){
                shipList.add(new Battleship("Battleship " + count));
                count++;
            }
            else if(j>2 && j<6){
                if(j==3){
                    count = 1;
                }
                shipList.add(new Submarine("Submarine " + count));
                count++;
            }
            else{
                if(j==6){
                    count = 1;
                }
                shipList.add(new PatrolBoat("Patrol boat " + count));
                count++;
            }
        }
        for(int i=0; i<10; i++){
            Validator.InputValidate(shipList.get(i), player_grid);
        }
        Playflow.playRound();
//        System.out.print("\n");
//        System.out.print("Your board is: ");
//        System.out.print("\n");
//        player_grid.printGrid();
//        System.out.print("\n");
//        System.out.print("\n");
//        System.out.print("Your opponent's board is: ");
//        System.out.print("\n");
//        ai_grid.printGrid();
    }


}



