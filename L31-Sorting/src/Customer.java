public class Customer {
    private final String name;
    private final int age;
    private final String sex;
    private final int netWorth;

    public Customer(String name, int age, String sex, int netWorth) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.netWorth = netWorth;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public int getNetWorth() {
        return netWorth;
    }

    public String toString(){
        return "\nName: " + name
                + " Age: " + age
                + " Sex: " + sex
                + " Net Worth: " + netWorth + "\n";

    }

    public void compareTo() {
    }
}