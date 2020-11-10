package cards;

public class Regular_CC extends Creditcard{
    public Regular_CC(
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
        this.limit=2000;

    }
}
