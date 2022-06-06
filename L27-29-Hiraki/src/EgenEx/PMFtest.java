package EgenEx;

import java.util.ArrayList;

public class PMFtest {
    public static void main(String[] args) {
        ArrayList<mechanic> mechanics = new ArrayList<>();
        ArrayList<foreman> foremen = new ArrayList<>();

        mechanic m1 = new mechanic("Jørgen", "Finlandsgade 2C", 1996,156);
        mechanic m2 = new mechanic("Lars", "Lollandsgade 58", 1987, 180);
        mechanic m3 = new mechanic("Søren", "Langelandsgade 206", 2001, 154);

        mechanics.add(m1);
        mechanics.add(m2);
        mechanics.add(m3);

        for (mechanic mechanic : mechanics){
            System.out.println(mechanic.weeklySalary(mechanics));
        }

        foreman f1 = new foreman("Lars", "Washingtongade 2009", 205, 2005, 56);

        foremen.add(f1);

        for (foreman foreman : foremen){
            System.out.println(foreman.weeklySalary(foremen));
        }
    }
}
