import boats.Ship;

import java.util.ArrayList;

public class Attacker {
    public static void AIAttack(Grid playergrid, ArrayList<Ship> playerList, Scoreboard scoreboard, Player player, Enemy enemy){
        int ShotV = Randomizer.getRandomNumberInRange(0,9);
        int ShotH = Randomizer.getRandomNumberInRange(0,9);
        if (playergrid.grid[ShotV][ShotH] != "[X]" && playergrid.grid[ShotV][ShotH] != "[O]" ){
            System.out.println("The computer attacks position " + Transformer.IntToStringTransform1(ShotH, ShotV));
            if(playergrid.grid[ShotV][ShotH] == "[ ]"){
                playergrid.grid[ShotV][ShotH] = "[O]";
                System.out.println("The computer missed");
            }
            else {
                playergrid.grid[ShotV][ShotH] = "[X]";
                for (int i = 0; i < 10; i++) {
                    Ship ship = playerList.get(i);
                    ArrayList<String> coordlist= ship.getCoordlist();
                    int size_coordlist = ship.getCoordlength();
                    for (int j=size_coordlist-1; j>=0; j--){
                        if (coordlist.get(j).equals(Integer.toString(ShotV) + Integer.toString(ShotH))) {
                            coordlist.remove(j);
                            int updated_length = ship.getCoordlength();
                            if (updated_length == 0) {
                                System.out.println("Your " + ship.getName() + " was destroyed!");
                                player.updateRemaining();
                                enemy.updateDestroyed();
                                scoreboard.updateScoreboard(player.getDestroyed(), player.getRemaining());
                            }
                            else{
                                System.out.println("Your boat was hit!");
                            }
                        }
                    }
                }
            }

        }
        else{
            AIAttack(playergrid, playerList, scoreboard, player, enemy);
        }
    }
}

