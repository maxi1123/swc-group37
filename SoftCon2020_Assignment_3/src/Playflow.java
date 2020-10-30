import boats.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Playflow {

    public static void initializeGame(Grid player_grid) {
        System.out.println("Welcome to Battleship!!");

        ArrayList<Ship> playerList = new ArrayList<>();

        // Loop for populating ArrayList<Ship> shipList with all available ships.

        int count = 1;

        for (int j = 0; j < 10; j++) {

            if (j == 0) {
                Carrier carrier = new Carrier();
                playerList.add(carrier);
                continue;
            } else if (j > 0 && j < 3) {
                playerList.add(new Battleship("Battleship " + count));
                count++;
            } else if (j > 2 && j < 6) {
                if (j == 3) {
                    count = 1;
                }
                playerList.add(new Submarine("Submarine " + count));
                count++;
            } else {
                if (j == 6) {
                    count = 1;
                }
                playerList.add(new PatrolBoat("Patrol boat " + count));
                count++;
            }
        }
        for (int i = 0; i < 10; i++) {
            Validator.InputValidate(playerList.get(i), player_grid);
        }
    }

    public static void playRound(Grid ai_grid_public, Grid ai_grid_hidden) {
        Enemy enemy = Enemy.getInstance();
        Player player = Player.getInstance();
        if (enemy.getRemaining() == 0) {
            System.out.println("You won");
        }
        if (player.getRemaining() == 0) {
            System.out.println("You lost");
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("Please enter the position of your attacking coordinates:");
            String position = input.next();
            if (!Validator.playerAttackValidate(position, ai_grid_public)) {
                //also check if coordinates were already chosen;
                System.out.println("Your Coordinates are invalid");
                playRound(ai_grid_public, ai_grid_hidden);
            } else {
                if (ai_grid_hidden.grid[Transformer.transformCoord(position.charAt(0))][position.charAt(1)] == " ") {
                    ai_grid_public.grid[Transformer.transformCoord(position.charAt(0))][position.charAt(1)] = "o";
                    ai_grid_hidden.grid[Transformer.transformCoord(position.charAt(0))][position.charAt(1)] = "o";
                    //AI_attack();
                    //print ai_grid_public and player grid and scoreboard
                } else {
                    ai_grid_public.grid[Transformer.transformCoord(position.charAt(0))][position.charAt(1)] = "X";
                    ai_grid_hidden.grid[Transformer.transformCoord(position.charAt(0))][position.charAt(1)] = "X";
                    //check if a whole ship has been hit, update grid if neccessary and
                    // update boats remaining/Scoreboard if neccessary
                    //print updated grids and scoreboard
                    playRound(ai_grid_public, ai_grid_hidden);
                }
            }
        }
    }
}
