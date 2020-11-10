package employees;
import customers.Customer;

import java.util.ArrayList;

public class Employee implements EmpOps{

    // employees.Employee details to be inherited by subclasses

    protected String name;
    protected String surname;
    protected int ID;
    protected ArrayList<Customer> customerlist;

    @Override
    public void upgradeGold(int ID){

        for(int i=0; i<customerlist.size(); i++){
            Customer customer = customerlist.get(i);
            if(customer.getID() == ID){
                customer.upgradeGold();
            }
        }
    }
}
