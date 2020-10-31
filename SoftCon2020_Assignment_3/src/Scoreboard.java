public class Scoreboard {
    int Boats_destroyed=0;
    int Boats_remaining=10;

    public void updateScoreboard(int boats_destroyed, int boats_remaining){
        Boats_destroyed=boats_destroyed;
        Boats_remaining=boats_remaining;
    }
    public void printScoreboard(){
        System.out.print("\n");
        System.out.println("\n" + "Your scoreboard:" + "\n" + "- Player remaining Boats: " + Boats_remaining + "\n" + "- Enemy Boats destroyed: " + Boats_destroyed);
    }
}
