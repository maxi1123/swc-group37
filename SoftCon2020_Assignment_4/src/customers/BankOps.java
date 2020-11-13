package customers;

public interface BankOps {

    void deposit(int amount);
    int withdraw(int amount);
    void transferPayment(int amount);
    String transferCard(int amount);

}
