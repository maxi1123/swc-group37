package employees;

public class WebTech extends Employee{

    public WebTech(String name,
                        String surname,
                        int ID){
        this.name = name;
        this.surname = surname;
        this.ID = ID;
    }

    public String fixWebsite(){
        try{
            Thread.sleep(30000);

        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("Reparations complete.");
        return "Reparations complete.";
    }
}
