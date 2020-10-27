public class Enemy {
    private int remaining_boats = 10;
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

    public void updateRemaining(){
        remaining_boats -= 1;
    }

}
