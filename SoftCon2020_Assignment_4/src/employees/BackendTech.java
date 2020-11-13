package employees;

public class BackendTech extends Employee{

    public BackendTech(String name,
                   String surname,
                   int ID){
        this.name = name;
        this.surname = surname;
        this.ID = ID;
    }

    public String fixBackend(int ID){
        System.out.println("Fixed!");
        return "Fixed!";
    }
}
