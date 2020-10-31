import boats.*;

import javax.swing.*;
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

    public static void playRound(Grid ai_grid_public, Grid ai_grid_hidden, Grid player_grid, Scoreboard scoreboard, Player player, Enemy enemy) {
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
                System.out.println("Your Coordinates are invalid");
                playRound(ai_grid_public, ai_grid_hidden, player_grid, scoreboard, player, enemy);
            } else {
                if (ai_grid_hidden.grid[Transformer.transformCoord(position.charAt(0))][position.charAt(1)].equals("[ ]")) {
                    ai_grid_public.grid[Transformer.transformCoord(position.charAt(0))][position.charAt(1)] = "o";
                    ai_grid_hidden.grid[Transformer.transformCoord(position.charAt(0))][position.charAt(1)] = "o";
                    /* AI_attack(player_grid)-->also change boats remaining if necessary and Scoreboard!; */
                    System.out.println("\n" + "Your Board is:" + "\n");
                    player_grid.printGrid();
                    System.out.println(("\n"+ "Your opponents board is:" + "\n"));
                    ai_grid_public.printGrid();
                    System.out.println("\n"+ "Your Scoreboard is:" + "\n");
                    scoreboard.printScoreboard();
                    playRound(ai_grid_public, ai_grid_hidden, player_grid, scoreboard, player, enemy);

                } else {
                    ai_grid_public.grid[Transformer.transformCoord(position.charAt(0))][position.charAt(1)] = "X";
                    ai_grid_hidden.grid[Transformer.transformCoord(position.charAt(0))][position.charAt(1)] = "X";
                    //check if a whole ship has been hit, update grid if neccessary and
                    //update boats remaining/Scoreboard if neccessary
                    //AI_ATTACK(player_grid, scoreboard, enemy, player)
                    //print updated grids and scoreboard
                    System.out.println("\n" + "Your Board is:" + "\n");
                    player_grid.printGrid();
                    System.out.println(("\n"+ "Your opponents board is:" + "\n"));
                    ai_grid_public.printGrid();
                    System.out.println("\n"+ "Your Scoreboard is:" + "\n");
                    scoreboard.printScoreboard();
                    playRound(ai_grid_public, ai_grid_hidden, player_grid, scoreboard, player, enemy);
                }
            }
        }
    }
}
