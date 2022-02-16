package ex2student;

public class Employee {
    // The name of the employee.
    private final String firstname;
    private final String lastname;
    private int age;
    // Whether the employee is a trainee or not.
    private boolean trainee;

    /**
     * Create an employee as a trainee with the given name.
     */
    public Employee(String firstname, String lastname,int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.trainee = true;
    }

    /**
     * Return the first name of the employee.
     */
    public String getFirstName() {
        return firstname;
    }
    /**
     * Return the last name of the employee.
     */
    public String getLastName() {
        return lastname;
    }

    /**
     * Return the trainee state of the employee.
     */
    public boolean isTrainee() {
        return trainee;
    }

    /**
     * Set the trainee state of the employee.
     */
    public void setTrainee(boolean trainee) {
        this.trainee = trainee;
    }

    /**
     * Return a description of the employee (for test purposes).
     */
    @Override
    public String toString() {
        return firstname + " (trainee: " + trainee + ")";
    }

    /**
     * Get age of employee
     */

    public int getAge(){
        return this.age;
    }

    /**
     * Set age of employee
     * @param age
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * Set birthday of employee
     */
    public void birthday(){
        this.age = age + 1;
    }

    /**
     * Print a description of the employee.
     */
    public void printEmployee() {
        System.out.println("*******************");
        System.out.println("Last Name: " + lastname);
        System.out.println("First Name: " + firstname);
        System.out.println("Trainee: " + trainee);
        System.out.println("Age: " + age);
        System.out.println("*******************");
    }
}
