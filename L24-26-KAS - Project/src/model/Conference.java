package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Conference {
    private String name;
    private String address;
    private double price;
    private String room;

    // Composition 1 -> 0..*
    private ArrayList<Excursion> excursions = new ArrayList<>();

    // Aggregering 1 - 0..*
    private ArrayList<Register> registers = new ArrayList<>();

    // association --> 0..* Hotel
    private final ArrayList<Hotel> hotels = new ArrayList<>();

    /**
     * Pre: Price for conference most be positive
     */
    //Package visible
    Conference(String name, String address, double price, String room) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getPrice() {
        return price;
    }

    public String getRoom() {
        return room;
    }

    public ArrayList<Excursion> getExcursions() {
        return excursions;
    }


    /**
     * Pre: price is positive.
     */
    public Excursion createExcursion(String name, LocalDate date, double price) {
        Excursion excursion = new Excursion(name, date, price);
        excursions.add(excursion);
        return excursion;
    }

    /**
     * Pre: The Register is not connected to a conference.
     */
    public void addRegister(Register register) {
        registers.add(register);
        register.conference = this;
    }


    // No Remove register not needed
    // Remove register not needed
//    public void removeRegister(Register register){
//      registers.remove(register);
//      register.conference = null;
//    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public ArrayList<Register> getRegisters() {
        return registers;
    }

    /**
     * Pre: The hotel is not connected to this conference.
     */
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
        hotel.conferences.add(this);
    }

    /**
     * Pre: The hotel is not connected to this conference.
     */
    public void removeHotel(Hotel hotel) {
        hotels.remove(hotel);
        hotel.conferences.remove(this);
    }

    public StringBuilder showParticipantOverview() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conference: " + name + "\n");
        for (Register register : registers) {
            sb.append("    " + register + "\n");
        }
        return sb;
    }

    @Override
    public String toString() {
        return name;
    }

    public StringBuilder showExcursionOverview() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conference: " + name + "\n");
        for (Excursion excursion : excursions) {
            sb.append("Excursion: " + excursion.getName() + "\n");
            for (Register register : registers) {
                if (register.getCompanion() != null) {
                    for (Excursion excursion1 : register.getCompanion().getExcursions()){
                        if (excursion1 == excursion){
                            sb.append("    " + register.getCompanion() + "\n");
                        }
                    }
                    //sb.append("    " + register.getCompanion() + "\n");
                }
            }
        }
        return  sb;
    }

    public StringBuilder showHotelOverview() {
        StringBuilder sb = new StringBuilder();
        for (Hotel hotel : hotels) {
            sb.append(hotel.getName() + "\n");
            for (Register register : hotel.getRegisters()){
                sb.append("    " + register + "\n");
            }
        }
        return sb;
    }
}
