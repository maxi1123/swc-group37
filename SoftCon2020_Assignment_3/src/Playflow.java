import boats.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Playflow {

    private static Playflow uniqueInstance;

    private Playflow() {}

    public static Playflow getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Playflow();
        }
        return uniqueInstance;
    }

    public static void initializeGame(){
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
    }

    public static void playRound() {
        Enemy enemy = new Enemy();
        Player player = new Player();
        if (enemy.getRemaining() == 0) {
            System.out.println("You won");
        }
        if (player.getRemaining() == 0) {
            System.out.println("You lost");
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("Please enter the position of your attacking coordinates");
            String position = input.next();
            if (ValidateCoordinates(position) == false) {
                System.out.println("Your Coordinates are invalid");
                playRound();
            }
            else {
                if ()
            }
        }
    }
}
