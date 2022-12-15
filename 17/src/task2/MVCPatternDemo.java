package task2;

public class MVCPatternDemo {
    public static void main(String[] args){
        Employee model = retriveEmployeeFromDatabase();
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(model, view);
        controller.updateView();
        controller.setEmployeeName("Dima");
        System.out.println("After updating: ");
        controller.updateView();
    }

    private static Employee retriveEmployeeFromDatabase(){
        Employee employee = new Employee();
        employee.setName("Alex");
        employee.setRate(1500);
        employee.setHours(40);
        return employee;
    }

}
