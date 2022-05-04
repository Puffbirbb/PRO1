package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Excursion {
    private String name;
    private LocalDate date;
    private double price;

    private ArrayList<Companion> companions = new ArrayList<>();

    // package visible;
    Excursion (String name, LocalDate date, double price){
        this.name = name;
        this.date = date;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    /**: The companion is not connected to this participant */
    public void addCompanions(Companion companion) {
        companions.add(companion);
        companion.getExcursions().add(this);
    }

    public ArrayList<Companion> getCompanions() {
        return companions;
    }

    @Override
    public String toString() {
        return "Excursion description: " + name;
    }
}
