package employees;
import customers.Customer;
import java.util.ArrayList;

public class RegularEmployee extends BankEmployee{

    public RegularEmployee(String name, String surname, int ID, ArrayList<Customer> customerlist){
        super(name, surname, ID);

        this.customerlist = customerlist;
    }
}
