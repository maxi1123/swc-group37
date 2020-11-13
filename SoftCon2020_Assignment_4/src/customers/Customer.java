package customers;
import cards.*;

public class Customer implements BankOps {

    // customers.Customer details to be inherited by subclasses

    protected String name;
    protected String surname;
    protected int age;
    protected int account_number;
    protected int savings;
    protected int ID;
    protected Creditcard creditcard;

    @Override
    public void deposit(int amount){
        this.savings += amount;
    }

    @Override
    public int withdraw(int amount){
        if(this.savings - amount >= 0){
            this.savings -= amount;
        }
        else{
            System.out.println("You do not have enough savings to withdraw the specified amount.");
        }
        return amount;
    }

    @Override
    public void transferPayment(int amount){
        if(this.savings - amount >= 0){
            this.savings -= amount;
        }
        else{
            System.out.println("You do not have enough savings to transfer the specified amount.");
        }
    }

    @Override
    public String transferCard(int amount){
        if(amount > this.creditcard.getLimit()){
            return "The specified amount exceeds your credit card limit.";
        }
        else{
            return "Transfer complete.";
        }
    }

    public int getID(){
        return this.ID;
    }

    public int getSavings(){
        return this.savings;
    }

    public Creditcard getCreditcard(){
        return this.creditcard;
    }

    public void setCreditcard(Creditcard creditcard){
        this.creditcard = creditcard;
    }

    public void upgradeGold(){
        this.creditcard = new Gold_CC(this.name,
                this.surname,
                this.creditcard.getSerial_number(),
                this.creditcard.getSecurity_code(),
                this.creditcard.getExpiration_date());
    }

    public void downgradeGold(){
        this.creditcard = new Regular_CC(this.name,
                this.surname,
                this.creditcard.getSerial_number(),
                this.creditcard.getSecurity_code(),
                this.creditcard.getExpiration_date());
    }

    public void upgradePlatinum(){
        this.creditcard = new Platinum_CC(this.name,
                this.surname,
                this.creditcard.getSerial_number(),
                this.creditcard.getSecurity_code(),
                this.creditcard.getExpiration_date());
    }

    public void downgradePlatinumToGold(){
        this.creditcard = new Gold_CC(this.name,
                this.surname,
                this.creditcard.getSerial_number(),
                this.creditcard.getSecurity_code(),
                this.creditcard.getExpiration_date());
    }

    public void downgradePlatinumToRegular(){
        this.creditcard = new Regular_CC(this.name,
                this.surname,
                this.creditcard.getSerial_number(),
                this.creditcard.getSecurity_code(),
                this.creditcard.getExpiration_date());
    }
}

