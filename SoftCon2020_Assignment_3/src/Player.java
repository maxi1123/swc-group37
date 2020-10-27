public class Player {
    private int remaining_boats = 10;
    private int boats_destroyed = 0;

    private static Player uniqueInstance;

    private Player() {}

    public static Player getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Player();
        }
        return uniqueInstance;
    }
    public int getRemaining(){
        return remaining_boats;
    }
    public int getDestroyed(){
        return boats_destroyed;
    }

    public void updateRemaining(){
        remaining_boats -= 1;
    }

    public void updateDestroyed(){
        boats_destroyed += 1;
    }

}
