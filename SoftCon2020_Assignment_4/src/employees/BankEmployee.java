package employees;
import cards.*;
import customers.Customer;
import java.util.ArrayList;


public class BankEmployee extends Employee implements EmpOps{

    public BankEmployee(String name,
                        String surname,
                        int ID,
                        ArrayList<Customer> customerlist){
        this.name = name;
        this.surname = surname;
        this.ID = ID;
        this.customerlist = customerlist;
    }

    protected ArrayList<Customer> customerlist;

    @Override
    public void upgradeGold(int ID){

        for(int i=0; i<customerlist.size(); i++){
            Customer customer = customerlist.get(i);
            if(customer.getID() == ID){
                if (customer.getCreditcard() instanceof Regular_CC){
                    customer.upgradeGold();
                }
                else{
                    System.out.println("Upgrade failed. Customer doesn't have a Regular Creditcard.");
                }
            }
        }
    }

    public void addCardToCustomer(Creditcard creditcard, Customer customer){
        customer.setCreditcard(creditcard);
    }
}
