package Employees;

public class MVCPatternDemo {
    public static void main(String[] args){
        //FOR THIS EXAMPLE, THE CREATED EMPLOYEE HAS TO HAVE THE ID "12345678" TO WORK, BUT THESE FUNCTIONS
        // GENERALLY WORK FOR ANY ID
        EmployeeController c = new EmployeeController();
        c.newEmployee();
        c.printEmployee("12345678");
        c.updateAddress("12345678");
        c.printAddress("12345678");
        c.updateNumber("12345678");
        c.printNumber("12345678");
    }
}
