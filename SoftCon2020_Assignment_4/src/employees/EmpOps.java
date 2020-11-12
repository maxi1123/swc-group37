package employees;

import cards.Creditcard;
import customers.Customer;

public interface EmpOps {

    void upgradeGold(int ID);
    void addCardToCustomer(Creditcard creditcard, Customer customer);

}
