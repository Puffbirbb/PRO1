package egenex;

public class PersonClass {
    // Person Name
    private final String name;
    //Person Address
    private String address;
    //Person Monthly Salary
    private int monthlySalary;

    /**
     * Constructor for Person
     */
    public PersonClass(String name, String address, int monthlySalary) {
        this.name = name;
        this.address = address;
        this.monthlySalary = monthlySalary;
    }

    /**
     * Return Name
     */
    public String getName(){

        return name;
    }

    /**
     * Set New Address
     */
    public void setAddress(String address){

        this.address = address;
    }

    /**
     * Return Address
     */
    public String getAddress(){

        return address;
    }

    /**
     * Set Monthly Salary
     */
    public void setMonthlySalary(int monthlySalary){

        this.monthlySalary = monthlySalary;
    }

    /**
     * Return Monthly Salary
     */
    public int getMonthlySalary(int monthlySalary){
        return monthlySalary;
    }

    /**
     * Print Person
     */
    public void printPersonClass() {
        System.out.println("*******************");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("*******************");
    }
}



