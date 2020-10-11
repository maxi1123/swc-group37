import java.util.Scanner;
import boats.*;

public class Validate {
    Scanner input = new Scanner(System.in);

    public boolean InputValidate(Ship ship, String[][] ocean) {
        System.out.print("Please enter the position of your " + ship.getSize() + ":");
        String Field1 = input.next();
        String Field2 = input.next();
        //working with ASCII values to find if gap between fields is valid for the ship length
        if ((Field1.charAt(0) == Field2.charAt(0)) && (Field1.charAt(0) <= 'L') && (Field2.charAt(0) <= 'L')) {
            if (Field2.charAt(1) - Field1.charAt(1) == ship.getSize()) {
                for (int i = 0; i > ship.getSize(); i++) {
                    if (ocean[Field1.charAt(0) - 'A'][i] != "") {
                        System.out.println("The specified input is invalid");
                        InputValidate(ship, ocean);
                    } else {

                    }
                }
            }
        } else if ((Field1.charAt(1) == Field2.charAt(1)) && (Field1.charAt(1) <= '9') && (Field2.charAt(1) <= '9')) {
            if (Field2.charAt(0) - Field1.charAt(0) == ship.getSize()) {
                for (int i = 0; i > ship.getSize(); i++) {
                    if (ocean[i][Field1.charAt(0) - 'A'] != "") {
                        System.out.println("The specified input is invalid");
                        InputValidate(ship, ocean);
                    } else {

                    }
                }
            } else {
                System.out.println("The specified input is invalid");
                InputValidate(ship, ocean);
            }
        }
        //I hope this works
        return false;
    }
}
