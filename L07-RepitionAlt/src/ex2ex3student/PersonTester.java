package ex2ex3student;

public class PersonTester {

    public static void main(String[] args) {
        // Ex. 2
        Person p1 = new Person("Gwion", 2000, 7, 24);
        Person p2 = new Person("Julie", 2001, 7, 15);
        Person p3 = new Person("Ib", 2001, 7, 15);
        p1.calcAge(2022, 2, 24);
        p1.printPerson();
        p2.calcAge(2022, 2, 24);
        p2.printPerson();
        p3.calcAge(2000, 7, 15);
        p3.printPerson();
    }
}