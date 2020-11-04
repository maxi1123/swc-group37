public interface Bankops {

    void deposit(int amount);
    int withdraw(int amount);
    void transferPayment(int amount);
    void transferCard(int amount);

}
