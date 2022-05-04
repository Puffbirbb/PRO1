package model;

import java.util.ArrayList;

public class Companion {
    public Participant participant; // OBS: package visible
    private String name;
    /** association --> 0..* */
    private ArrayList<Excursion> excursions = new ArrayList<>();

    public Companion (String name){ //OBS: package visible
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Excursion> getExcursions() {
        return new ArrayList<Excursion>(excursions);
    }

    public ArrayList<Excursion> addExcursions(Excursion excursion) {
        excursions.add(excursion);
        return new ArrayList<>(excursions);
    }

    public Participant getParticipant() {
        return participant;
    }

    public void add(Companion companion) {
    }

    @Override
    public String toString() {
        return "Companion: " +
                "name: " + name +
                "{participan: " + participant.getName() +
                ", phonenumber: " + participant.getPhoneNumber() +
                '}';
    }
}

