public class Player {
    private int remaining_boats = 10;
    private int boats_destroyed = 0;

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
