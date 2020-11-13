package employees;
import cards.*;
import customers.Customer;
import java.util.ArrayList;

public class MainChief extends BankEmployee{

        public MainChief(String name, String surname, int ID, ArrayList<Customer> customerlist){
            super(name, surname, ID, customerlist);

            this.customerlist = customerlist;
        }

    public void downgradeGold(int ID){

        for(int i=0; i<customerlist.size(); i++){
            Customer customer = customerlist.get(i);
            if(customer.getID() == ID){
                if (customer.getCreditcard() instanceof Gold_CC){
                    customer.downgradeGold();
                }
                else{
                    System.out.println("Downgrade failed. Customer doesn't have a Gold Creditcard.");
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

    public void downgradePlatinumToGold(int ID){

        for(int i=0; i<customerlist.size(); i++){
            Customer customer = customerlist.get(i);
            if(customer.getID() == ID){
                if (customer.getCreditcard() instanceof Platinum_CC){
                    customer.downgradePlatinumToGold();
                }
                else{
                    System.out.println("Downgrade failed. Customer doesn't have a Platinum Creditcard.");
                }
            }
        }
    }
    public void downgradePlatinumToRegular(int ID){

        for(int i=0; i<customerlist.size(); i++){
            Customer customer = customerlist.get(i);
            if(customer.getID() == ID){
                if (customer.getCreditcard() instanceof Platinum_CC){
                    customer.downgradePlatinumToRegular();
                }
                else{
                    System.out.println("Downgrade failed. Customer doesn't have a Platinum Creditcard.");
                }
            }
        }
    }
}
