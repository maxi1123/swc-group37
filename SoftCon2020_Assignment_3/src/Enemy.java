public class Enemy {
    private int remaining_boats = 10;

    public int getRemaining(){
        return remaining_boats;
    }

    public void updateRemaining(){
        remaining_boats -= 1;
    }

}
