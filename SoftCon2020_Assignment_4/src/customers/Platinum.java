package customers;
import cards.Platinum_CC;

public class Platinum extends Customer{

    public Platinum(String name,
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
        this.creditcard = new Platinum_CC(this.name, this.surname, 123, 123, 123);
    }

}
