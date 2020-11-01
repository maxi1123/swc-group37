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

    public static void playRound(Grid ai_grid_public, Grid ai_grid_hidden, Grid player_grid, Scoreboard scoreboard, Player player, Enemy enemy, ArrayList<Ship> AIlist) {
        if (enemy.getRemaining() == 0) {
            System.out.println("Congratulations, you won!");
            return;
        }
        if (player.getRemaining() == 0) {
            System.out.println("Sorry, you lost!");
            return;
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("\n" + "Enter the position you want to attack: ");
            String position = input.next();
            if (!Validator.playerAttackValidate(position, ai_grid_public)) {
                System.out.println("Your Coordinates are invalid");
                playRound(ai_grid_public, ai_grid_hidden, player_grid, scoreboard, player, enemy, AIlist);
            } else {
                if (ai_grid_hidden.grid[position.charAt(1) - '0'][Transformer.transformCoord(position.charAt(0))].equals("[ ]")) {
                    ai_grid_public.grid[position.charAt(1) - '0'][Transformer.transformCoord(position.charAt(0))] = "[O]";
                    ai_grid_hidden.grid[position.charAt(1) - '0'][Transformer.transformCoord(position.charAt(0))] = "[O]";
                    /* AI_attack(player_grid)-->also change boats remaining if necessary and Scoreboard!; */
                    System.out.print("Miss");
                    System.out.println("\n" + "Your board is:");
                    player_grid.printGrid();
                    System.out.print("\n");
                    System.out.println(("\n" + "Your opponents board is:"));
                    ai_grid_public.printGrid();
                    scoreboard.printScoreboard();
                    playRound(ai_grid_public, ai_grid_hidden, player_grid, scoreboard, player, enemy, AIlist);

                } else {
                    ai_grid_public.grid[position.charAt(1) - '0'][Transformer.transformCoord(position.charAt(0))] = "[X]";
                    ai_grid_hidden.grid[position.charAt(1) - '0'][Transformer.transformCoord(position.charAt(0))] = "[X]";
                    for (int i=0;i<10;i++){
//                        AIlist.get(i).copyCoordlist();
//                        ArrayList<String> backup = AIlist.get(i).getBackup();
                        Ship ship = AIlist.get(i);
                        ArrayList<String> coordlist= ship.getCoordlist();
                        int size_coordlist = ship.getCoordlength();
                        for (int j=size_coordlist-1; j>=0; j--){
                            if (coordlist.get(j).equals(position.charAt(1) + Integer.toString(position.charAt(0)-'A'))){
                                AIlist.get(i).copyCoordlist();
                                ArrayList<String> backup = AIlist.get(i).getBackup();
                                coordlist.remove(j);
                                int updated_length = ship.getCoordlength();
                                if(updated_length==0){
                                    enemy.updateRemaining();
                                    player.updateDestroyed();
                                    scoreboard.updateScoreboard(player.getDestroyed(), player.getRemaining());
                                    for(int x = backup.size()-1; x>=0; x--){
                                        String coord = backup.get(x);
                                        int coordone = Integer.parseInt(String.valueOf(coord.charAt(0)));
                                        int coordtwo = Integer.parseInt(String.valueOf(coord.charAt(1)));
                                        ai_grid_public.grid[coordone][coordtwo] = "[" + ship.getType() + "]";
                                    }

                                    System.out.print("You destroyed their " + ship.getName());
                                }
                                else{
                                    System.out.print("You hit a boat!");
                                }
                            }
                        }
                    }
                    //check if a whole ship has been hit, update grid if neccessary and
                    //update boats remaining/Scoreboard if neccessary
                    //AI_ATTACK(player_grid, scoreboard, enemy, player)
                    //print updated grids and scoreboard
                    System.out.println("\n" + "Your board is:");
                    player_grid.printGrid();
                    System.out.print("\n");
                    System.out.println(("\n" + "Your opponents board is:"));
                    ai_grid_public.printGrid();
                    scoreboard.printScoreboard();
                    playRound(ai_grid_public, ai_grid_hidden, player_grid, scoreboard, player, enemy, AIlist);
                }
            }
        }
    }
}
