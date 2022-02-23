package egenexL05;

public class EX4app {
    public static void main(String[] args){
        EX4Class Person1 = new EX4Class("Juan", " ", "Deag", "Juan Deag");
        Person1.setFirstName("Jens");
        Person1.setMiddleName("Jørgen");
        Person1.setLastName("Rorsharch");
        Person1.setFullName("Jens Jørgen Rorsharch");
        Person1.printEX4Class();
        System.out.println(Person1.userName());
        System.out.println(Person1.getFirstName() + " "
                + Person1.getMiddleName() + " "
                + Person1.getLastName());
        System.out.println(Person1.getInits());
    }
}
