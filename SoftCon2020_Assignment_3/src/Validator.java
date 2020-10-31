import boats.Ship;

import java.util.Scanner;

public class Validator {


    public static boolean InputValidate(Ship ship, Grid ocean) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the position of your " + ship.getName() + ":");
        String Field1 = input.next();
        String Field2 = input.next();
        //working with ASCII values to find if gap between fields is valid for the ship length
        if ((Field1.charAt(0) == Field2.charAt(0)) && (Field1.charAt(0) <= 'J') && (Field2.charAt(0) <= 'J') && (Field1.length() == 2) && (Field2.length() == 2)) {
            if (Field2.charAt(1) - Field1.charAt(1) + 1 == ship.getSize()) {
                for (int i = 0; i < ship.getSize(); i++) {
                    if (ocean.grid[i+Field1.charAt(1)-'0'][Field1.charAt(0) - 'A'] != "[ ]") {
                        System.out.println("The specified input is invalid");
                        InputValidate(ship, ocean);
                        return false;
                    }

                }
                ocean.Insert(ship,Field1,Field2);
                return true;
            }
        }
        else if ((Field1.charAt(1) == Field2.charAt(1)) && (Field1.charAt(1) <= '9') && (Field2.charAt(1) <= '9') && (Field1.length() == 2) && (Field2.length() == 2)) {
            if (Field2.charAt(0) - Field1.charAt(0) + 1 == ship.getSize()) {
                for (int i = 0; i < ship.getSize(); i++) {
                    if (ocean.grid[Field1.charAt(1)-'0'][i+Field1.charAt(0)-'A'] != "[ ]") {
                        System.out.println("The specified input is invalid");
                        InputValidate(ship, ocean);
                        return false;
                    }
                }
                ocean.Insert(ship,Field1,Field2);
                return true;
            }
            else {
                System.out.println("The specified input is invalid");
                InputValidate(ship, ocean);
                return false;
            }
        }
        System.out.println("The specified input is invalid");
        InputValidate(ship, ocean);
        //I hope this works
        return false;
    }

    public static boolean playerAttackValidate(String position, Grid AIGrid){
        Transformer t = new Transformer();
        int LetterPos = t.transformCoord(position.charAt(0));
        int NumberPos = position.charAt(1) - '0';
        System.out.println(LetterPos);
        System.out.println(NumberPos);
        if (position.length() == 2){
            if(LetterPos <= 9 && NumberPos <= 9){
                if( AIGrid.grid[NumberPos][LetterPos] == "[ ]"){
                    return true;
                }
            }
        }
        return false;
    }
}
