package cards;

public class Gold_CC extends Creditcard{
    public Gold_CC(
            String name,
            String surname,
            int serial_number,
            int security_code,
            int expiration_date){
        this.name=name;
        this.surname=surname;
        this.serial_number=serial_number;
        this.security_code=security_code;
        this.expiration_date=expiration_date;
        this.limit=5000;

    }
}