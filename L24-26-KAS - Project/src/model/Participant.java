package model;

import java.util.ArrayList;

public class Participant {
    private String name;
    private String city;
    private String country;
    private int phoneNumber;
    private String businessName;
    private int businessPhoneNumber;
    /** composition -> 0..* Companion */
    private ArrayList<Companion> companions = new ArrayList<>();
    private ArrayList<Register> registers = new ArrayList<>();

    public Participant (String name, String city, String country, int phoneNumber, String businessName, int businessPhoneNumber){
        this.name = name;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.businessName = businessName;
        this.businessPhoneNumber = businessPhoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getBusinessName() {
        return businessName;
    }

    public int getBusinessPhoneNumber() {
        return businessPhoneNumber;
    }

    public ArrayList<Companion> getCompanions() {
        return new ArrayList<>(companions);
    }

    public void addCompanion(Companion companion){
        companions.add(companion);
        companion.participant = this;
    }

    public Companion createCompanion(String name) {
        Companion companion = new Companion(name);
        companions.add(companion);
        return companion;
    }

    public ArrayList<Register> getRegisters() {
        return new ArrayList<>(registers);
    }

    @Override
    public String toString() {
        return name;
    }
}