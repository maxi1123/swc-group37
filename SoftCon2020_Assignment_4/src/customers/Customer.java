package customers;

public class Customer implements Bankops {

    // customers.Customer details to be inherited by subclasses

    protected String name;
    protected String surname;
    protected int age;
    protected int account_number;
    protected int savings;
    protected int ID;

    public void deposit(int amount){
        this.savings += amount;
    }

    public int withdraw(int amount){
        if(this.savings - amount >= 0){
            this.savings -= amount;
        }
        else{
            System.out.println("You do not have enough savings to withdraw the specified amount.");
        }
        return amount;
    }

    public void transferPayment(int amount){
        if(this.savings - amount >= 0){
            this.savings -= amount;
        }
        else{
            System.out.println("You do not have enough savings to transfer the specified amount.");
        }
    }

    public void transferCard(int amount){

    }

}

