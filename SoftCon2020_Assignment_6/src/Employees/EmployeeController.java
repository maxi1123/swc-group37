package Employees;

public class EmployeeController {
    EmployeeViewer Viewer = new EmployeeViewer();
    EmployeeModel Model = new EmployeeModel();

    public void newEmployee(){
        Employee x = Viewer.createNewEmployee();
        Model.addEmployee(x);
    }

    public void printEmployee(String ID){
        Viewer.printEmployee(Model.getEmployee(ID));
    }

    public void updateAddress(String ID){
        Employee x = Model.getEmployee(ID);
        x.address = Viewer.getAddress();
    }

    public void printAddress(String ID){
        Employee x = Model.getEmployee(ID);
        Viewer.printAddress(x);
    }

    public void updateNumber(String ID){
        Employee x = Model.getEmployee(ID);
        x.phone = Viewer.getNumber();
    }

    public void printNumber(String ID){
        Employee x = Model.getEmployee(ID);
        Viewer.printNumber(x);
    }
}
