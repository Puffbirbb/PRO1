package EgenEx;

import java.util.ArrayList;

public class foreman extends Person {
    private static double hourlyWage;
    private int yearOfForemanship;
    private static double bonusWage;

    public foreman(String name, String address, double hourlyWage, int yearOfForemanship, double bonusWage) {
        super(name, address);
        this.hourlyWage = hourlyWage;
        this.yearOfForemanship = yearOfForemanship;
        this.bonusWage = bonusWage;
    }

    public static double weeklySalary(ArrayList<foreman> foremen) {
        return hourlyWage = (hourlyWage + bonusWage) * 37;
    }
}
