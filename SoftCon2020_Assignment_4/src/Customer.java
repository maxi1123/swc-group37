public class Customer implements Bankops {

    // Customer details to be inherited by subclasses

    protected String name;
    protected String surname;
    protected int age;
    protected int account_number;
    protected int savings;
    protected int ID;

    public void deposit(int amount){

    }

    public int withdraw(int amount){
        return 1;
    }

    public void transferPayment(int amount){

    }

    public void transferCard(int amount){

    }
}

