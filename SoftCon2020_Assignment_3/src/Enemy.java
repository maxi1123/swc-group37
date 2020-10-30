public class Enemy {
    private int remaining_boats = 10;
    private int boats_destroyed=0;
    private static Enemy uniqueInstance;

    private Enemy() {}

    public static Enemy getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Enemy();
        }
        return uniqueInstance;
    }

    public int getRemaining(){
        return remaining_boats;
    }
    public int getBoats_destroyed(){return boats_destroyed;}

    public void updateRemainingBoats(){
        remaining_boats -= 1;
    }
    public void updateBoatsDestroyed() { boats_destroyed += 1;}

}
