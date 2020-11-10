package customers;
import cards.Regular_CC;

public class Regular extends Customer {

    public Regular(String name,
                                  String surname,
                                  int age,
                                  int account_number,
                                  int savings,
                                  int ID){

        this.name = name;
        this.surname = surname;
        this.age = age;
        this.account_number = account_number;
        this.savings = savings;
        this.ID = ID;
        this.creditcard = new Regular_CC(this.name, this.surname, 123, 123, 123);
    }

}
