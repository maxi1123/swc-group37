import customers.*;

public class Main {
    public static void main(String[] args){
        Regular max = new Regular("Max", "Jonescu", 21, 1234, 12000, 284920128);
        max.deposit(10000);
        max.withdraw(30000);
    }
}
