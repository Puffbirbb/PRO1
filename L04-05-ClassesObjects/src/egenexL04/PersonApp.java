package egenexL04;

public class PersonApp {
    public static void main(String[] args){
        PersonClass juan = new PersonClass("Juan", "Finlandsgade 2C", 10000);
        juan.setMonthlySalary(20000);
        juan.setAddress("Pennsylvania Avenue NW, Washington");
        juan.printPersonClass();
    }
}
