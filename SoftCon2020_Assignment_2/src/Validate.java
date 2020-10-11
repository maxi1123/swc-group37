import java.util.Scanner;

public class Validate {
    Scanner input = new Scanner(System.in);

    public boolean InputValidator(Ship ship, Ocean[][] ocean){
        System.out.print("Please enter the position of your "+ship.name+":");
        String Field1 = input.next();
        String Field2 = input.next();
        //working with ASCII values to find if gap between fields is valid for the ship length
        if ((Field1.charAt(0) == Field2.charAt(0))&&(Field1.charAt(0)<='L')&&(Field2.charAt(0)<='L')){
            if (Field2.charAt(1)-Field1.charAt(1)==ship.length) {
                for (int i=0;i>ship.length;i++){
                    if (ocean[Field1.charAt(0)-'A'][i] != []){
                        System.out.println("The specified input is invalid");
                        return false;
                    }
                return true;
            }
            else{
                System.out.println("The specified input is invalid");
                return false;
            }
        }
        else if (Field1.charAt(1)==Field2.charAt(1)){
            if (Field2.charAt(0)-Field1.charAt(0)==ship.length){

            }
            else{
                System.out.println("The specified input is invalid");
                return false;
            }
        }
        return false;
    }
    //I hope this works
}
