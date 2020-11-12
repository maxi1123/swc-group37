package employees;
import cards.*;
import customers.Customer;
import java.util.ArrayList;

public class SectionChief extends BankEmployee{

    protected String city;

    public SectionChief(String name, String surname, int ID, ArrayList<Customer> customerlist, String city){
        super(name, surname, ID, customerlist);

        this.customerlist = customerlist;
        this.city = city;
    }

    public void downgradeGold(int ID){

        for(int i=0; i<customerlist.size(); i++){
            Customer customer = customerlist.get(i);
            if(customer.getID() == ID){
                if (customer.getCreditcard() instanceof Gold_CC){
                    customer.downgradeGold();
                }
                else{
                    System.out.println("Upgrade failed. Customer doesn't have a Gold Creditcard.");
                }
            }
        }
    }

    public void upgradePlatinum(int ID){

        for(int i=0; i<customerlist.size(); i++){
            Customer customer = customerlist.get(i);
            if(customer.getID() == ID){
                if (customer.getCreditcard() instanceof Gold_CC){
                    customer.upgradePlatinum();
                }
                else{
                    System.out.println("Upgrade failed. Customer doesn't have a Gold Creditcard.");
                }
            }
        }
    }
}
