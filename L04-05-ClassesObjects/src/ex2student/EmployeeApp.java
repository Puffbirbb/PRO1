package ex2student;


public class EmployeeApp {

    public static void main(String[] args) {
        Employee e1 = new Employee("Hans ", "Jensen", 29);
        e1.setTrainee(false);
        e1.birthday();
        e1.printEmployee();
        System.out.println();
    }
}
