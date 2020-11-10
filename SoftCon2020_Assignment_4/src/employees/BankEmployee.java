package employees;
import cards.Regular_CC;
import customers.Customer;
import java.util.ArrayList;


public class BankEmployee extends Employee implements EmpOps{

    public BankEmployee(String name,
                        String surname,
                        int ID){
        this.name = name;
        this.surname = surname;
        this.ID = ID;
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
}
