package cards;

public class Creditcard {
    protected String name;
    protected String surname;
    protected int serial_number;
    protected int security_code;
    protected int expiration_date;
    protected int limit;

    public int getLimit(){
        return this.limit;
    }

    public int getSerial_number(){
        return this.serial_number;
    }

    public int getSecurity_code(){
        return this.security_code;
    }

    public int getExpiration_date() {
        return this.expiration_date;
    }
}

