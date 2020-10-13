import boats.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to Battleship!!");
        Grid newgrid = new Grid();
        newgrid.buildGrid();

        // Hardcoding looks awful but does the job...

        Ship[] shipObjects = new Ship[10];

        Carrier carrier = new Carrier();
        Battleship battleship1 = new Battleship();
        battleship1.setName("Battleship 1");
        Battleship battleship2 = new Battleship();
        battleship2.setName("Battleship 2");
        Submarine submarine1 = new Submarine();
        submarine1.setName("Submarine 1");
        Submarine submarine2 = new Submarine();
        submarine2.setName("Submarine 2");
        Submarine submarine3 = new Submarine();
        submarine3.setName("Submarine 3");
        PatrolBoat patrolboat1 = new PatrolBoat();
        patrolboat1.setName("Patrol boat 1");
        PatrolBoat patrolboat2 = new PatrolBoat();
        patrolboat2.setName("Patrol boat 2");
        PatrolBoat patrolboat3 = new PatrolBoat();
        patrolboat3.setName("Patrol boat 3");
        PatrolBoat patrolboat4 = new PatrolBoat();
        patrolboat4.setName("Patrol boat 4");


        shipObjects[0] = carrier;
        shipObjects[1] = battleship1;
        shipObjects[2] = battleship2;
        shipObjects[3] = submarine1;
        shipObjects[4] = submarine2;
        shipObjects[5] = submarine3;
        shipObjects[6] = patrolboat1;
        shipObjects[7] = patrolboat2;
        shipObjects[8] = patrolboat3;
        shipObjects[9] = patrolboat4;

        for(int i=0; i<10; i++){
            InputValidate(shipObjects[i], newgrid);
        }
        newgrid.printGrid();
    }


    public static boolean InputValidate(Ship ship, Grid ocean) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the position of your " + ship.getName() + ":");
        String Field1 = input.next();
        String Field2 = input.next();
        //working with ASCII values to find if gap between fields is valid for the ship length
        if ((Field1.charAt(0) == Field2.charAt(0)) && (Field1.charAt(0) <= 'J') && (Field2.charAt(0) <= 'J')) {
            if (Field2.charAt(1) - Field1.charAt(1) + 1 == ship.getSize()) {
                for (int i = 0; i < ship.getSize(); i++) {
                    if (ocean.grid[i+Field1.charAt(1)-'0'][Field1.charAt(0) - 'A'] != "[ ]") {
                        System.out.println("The specified input is invalid");
                        InputValidate(ship, ocean);
                    }

                    }
                ocean.Insert(ship,Field1,Field2,ocean);
                return true;
                }
            }
         else if ((Field1.charAt(1) == Field2.charAt(1)) && (Field1.charAt(1) <= '9') && (Field2.charAt(1) <= '9')) {
            if (Field2.charAt(0) - Field1.charAt(0) + 1 == ship.getSize()) {
                for (int i = 0; i < ship.getSize(); i++) {
                    if (ocean.grid[Field1.charAt(1)-'0'][i+Field1.charAt(0)-'A'] != "[ ]") {
                        System.out.println("The specified input is invalid");
                        InputValidate(ship, ocean);
                    }
                }
                ocean.Insert(ship,Field1,Field2,ocean);
                return true;
            }
            else {
                System.out.println("The specified input is invalid");
                InputValidate(ship, ocean);
            }
        }
        System.out.println("The specified input is invalid");
        InputValidate(ship, ocean);
        //I hope this works
        return false;
    }
}



