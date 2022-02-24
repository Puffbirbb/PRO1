package ex2ex3student;

public class Person {
    private final String name;
    private final int dayOfBirth; // 1..31
    private final int monthOfBirth; // 1..12
    private final int yearOfBirth; // 1900..2010

    public Person(String name, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public int calcAge(int year, int month, int day){
        int age = 0;
        if (month>=monthOfBirth){
            if (day >= dayOfBirth){
                if (year > yearOfBirth){
                    age = year - yearOfBirth;
                    System.out.println(age);
                }
            }
        }
        else {
            age = year - yearOfBirth - 1;
            System.out.println(age);
        }
        return age;
    }

    public void printPerson() {
        System.out.println(name + ", born " + yearOfBirth + "-" + monthOfBirth + "-" + dayOfBirth);
    }
}
