package Employees;
import java.util.ArrayList;

public class EmployeeModel {
    ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee emp){
        employees.add(emp);
    }

    public Employee getEmployee(String Id){
        Employee xyz = null;
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).ID.equals(Id)){
                return employees.get(i);
            }
        }
        return null;
    }
}
