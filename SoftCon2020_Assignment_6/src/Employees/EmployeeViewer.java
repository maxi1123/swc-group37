package Employees;
import java.util.Scanner;

public class EmployeeViewer {
    Scanner input = new Scanner(System.in);

    public void printEmployee(Employee emp){
        System.out.print(emp.name);
        System.out.print(" ");
        System.out.println(emp.surname);
        System.out.println(emp.ID);
    }

    public void printAddress(Employee emp){
        System.out.println(emp.address);
    }

    public void printNumber(Employee emp){
        System.out.println(emp.phone);
    }

    public String getID(){
        String ID = "0";
        System.out.println("Enter new ID:");
        ID = input.next();
        if( ID.length() == 8) {
            return ID;
        }
        else{
            System.out.println("Wrong ID Length");
            return getID();
        }
    }
    public String getAddress(){
        String add = " ";
        System.out.println("Enter new Address:");
        input.nextLine();
        add = input.nextLine();
        return add;
    }
    public long getNumber(){
        long number = 0;
        System.out.println("Enter new Number:");
        number = Long.parseLong(input.nextLine());
        return number;
    }

    public Employee createNewEmployee(){
        System.out.println("Enter First Name:");
        String name = input.next();
        System.out.println("Enter Surname:");
        String surname = input.next();
        System.out.println("Enter Phone Number:");
        Long number = Long.parseLong(input.next());
        System.out.println("Enter Address:");
        input.nextLine();
        String address = input.nextLine();
        Employee emp = new Employee(name, surname,address,number, getID());
        return emp;
    }

}
