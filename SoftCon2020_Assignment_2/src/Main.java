import boats.*;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to Battleship!!");
        Grid newgrid = new Grid();
        newgrid.buildGrid();



//        // Populate shipObjects with all the available ships
//        Ship[] shipObjects = new Ship[10];
//
//        int i;

//        for(i=0; i<10; i++){
//            if(i>5){
//                PatrolBoat patrolboat = new PatrolBoat();
//                shipObjects[i] = patrolboat;
//            }
//            else if(i>2){
//                Submarine submarine = new Submarine();
//                shipObjects[i] = submarine;
//            }
//            else if(i>0){
//                Battleship battleship = new Battleship();
//                shipObjects[i] = battleship;
//            }
//            else{
//                Carrier carrier = new Carrier();
//                shipObjects[i] = carrier;
//            }
//        }
    }

}
