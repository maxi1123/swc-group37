import boats.Ship;

import java.util.Scanner;

public class Validator {
    public boolean InputValidate(Ship ship, Grid ocean) {
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
