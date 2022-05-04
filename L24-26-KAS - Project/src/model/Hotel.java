package model;

import java.util.ArrayList;

public class Hotel {

    private String name;
    private double singleRoomPrice;
    private double doubleRoomPrice;

    // composition -> 0..* Person
    private final ArrayList<Extra> extras = new ArrayList<>();
    // association --> 0..* Register
    private final ArrayList<Register> registers = new ArrayList<>();
    // association --> 0..* Conference
    final ArrayList<Conference> conferences = new ArrayList<>(); // OBS: package visible


    /**
     * Pre: Price for single and double room must be positive
     */
    public Hotel(String name, double singleRoomPrice, double doubleRoomPrice){
        this.name = name;
        this.singleRoomPrice = singleRoomPrice;
        this.doubleRoomPrice = doubleRoomPrice;
    }

    public String getName() {
        return name;
    }

    public double getSingleRoom() {
        return singleRoomPrice;
    }

    public double getDoubleRoom() {
        return doubleRoomPrice;
    }

    public ArrayList<Extra> getExtras() {
        return extras;
    }

    /**
     * Pre: Price must be positive
     */
    public Extra createExtra(String name, double price){
        Extra extra = new Extra(name, price);
        extras.add(extra);
        return extra;
    }

    public ArrayList<Register> getRegisters() {
        return new ArrayList<>(registers);
    }
    /**
     * Pre: The register is not connected to a hotel.
     */
    public void addRegister(Register register){
        registers.add(register);
        register.hotel = this;
    }

    /**
     * Pre: The register is not connected to a hotel.
     */
    public void removeRegister(Register register){
        registers.remove(register);
        register.hotel = null;
    }

    public ArrayList<Conference> getConferences() {
        return new ArrayList<>(conferences);
    }

    public double rentHotelRoom(Register register) {
        if (register.getCompanion() == null){
            return singleRoomPrice;
        }
        else {
            return doubleRoomPrice;
        }
    }

    @Override
    public String toString() {
        return name;
    }

//    public StringBuilder allExtras(){
//        StringBuilder e = new StringBuilder();
//        for (int i = 0; i < extras.size(); i++) {
//            e.append(extras.get(i).getName());
//        }
//        return e;
//    }

    public String allExtras(){
        String s = "hej";
        return s;
    }


}
