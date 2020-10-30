import boats.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Grid player_grid = new Grid();
        player_grid.buildGrid();
        Playflow.initializeGame(player_grid);
        Grid ai_grid_hidden = new Grid();
        ai_grid_hidden.buildGrid();
        ArrayList<Ship> AIList = ai_grid_hidden.generateAIFleet();
        ai_grid_hidden.placeAI(AIList, 0, ai_grid_hidden);
        Grid ai_grid_public = new Grid();
        ai_grid_public.buildGrid();
        Playflow.playRound(ai_grid_public, ai_grid_hidden);

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



