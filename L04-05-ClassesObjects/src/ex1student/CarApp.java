package ex1student;

public class CarApp {

    public static void main(String[] args) {
        Car SmallCar = new Car("VW UP", "White", "AB 12.345");
        SmallCar.setKm(5000);
        System.out.println(SmallCar.getBrand() + ", " + SmallCar.getColor());
        System.out.println(SmallCar.getKm());
        System.out.println();


        Car MediumCar = new Car("Tesla Model S","Pearl Black", "GW 69.420" );
        MediumCar.setKm(420000);
        System.out.println("*********************");
        System.out.println("* Brand: " + MediumCar.getBrand());
        System.out.println("* Color: " + MediumCar.getColor());
        System.out.println("* RegNr.: " + MediumCar.getRegistrationNumber());
        System.out.println("* Km. Driven: " + MediumCar.getKm());
        System.out.println("*********************");

    }
}
