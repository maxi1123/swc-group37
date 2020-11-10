package employees;
import customers.Customer;
import java.util.ArrayList;


public class RegularEmployee extends Employee{

    public RegularEmployee(String name, String surname, int ID, ArrayList<Customer> customerlist){

        this.name = name;
        this.surname = surname;
        this.ID = ID;
        this.customerlist = customerlist;
    }
}
