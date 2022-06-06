package EgenEx;

import java.util.ArrayList;

public class mechanic extends Person{
    private int yearOfGraduation;
    private static double hourlyWage;


    public mechanic(String name, String address, int yearOfGraduation, double hourlyWage) {
        super(name, address);
        this.yearOfGraduation = yearOfGraduation;
        this.hourlyWage = hourlyWage;
    }

    public static double weeklySalary(ArrayList<mechanic> mechanics){
        return hourlyWage = hourlyWage * 37;
    }
}
