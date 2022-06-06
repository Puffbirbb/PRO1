package EgenEx3p2;

public class Customer implements Comparable{
    public String firstName;
    public String lastName;
    public int age;

    public Customer(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String compareTo() {
        return firstName + lastName;
    }
}
