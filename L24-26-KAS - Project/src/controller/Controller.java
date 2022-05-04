package controller;

//import model.*;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    /**
     * Create organisation
     * Pre: name not empty
     * */
    public static Organisation createOrganisation(String name){
        Organisation organisation = new Organisation(name);
        Storage.storeOrganisation(organisation);
        return organisation;
    }

    public static ArrayList<Organisation> getOrganisations(){
        return Storage.getOrganisations();
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Create a new conference
     * Pre: name not empty, address not empty, price not negative, room not empty
     * */
    public static Conference createConference(String name, String address, double price, String room, Organisation organisation){
        Conference conference = organisation.createConference(name, address, price, room);
        Storage.storeConference(conference);
        return conference;
    }

    /**
     * Delete a new conference
     * Pre: name not empty, address not empty, price not negative, room not empty
     * */
    public static Conference deleteConference(Organisation organisation, String name, String address, double price, String room){
        Conference conference = organisation.createConference(name, address, price, room);
        //Storage.deleteConference(conference);
        return conference;
    }

    public ArrayList<Conference> getConferences(){
        return Storage.getConferences();
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Create a new excursion
     * Pre: name not empty, date is within the boundaries, price not negative
     * */
    public static Excursion createExcursion(String name, LocalDate date, double price, Conference conference){
        Excursion excursion = conference.createExcursion(name, date, price);
        return excursion;
    }

    public static void addHotel(Hotel hotel, Conference conference){
        conference.addHotel(hotel);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Create a new register
     * Pre:
     * */
    public static Register createRegister(LocalDate arrival, LocalDate departure, boolean lecturer, Participant participant, Conference conference){
        Register register = new Register(arrival, departure, lecturer, participant, conference);
        conference.addRegister(register);
        Storage.storeRegister(register);
        return register;
    }

    public static void setCompanion(Companion companion, Register register){
         register.setCompanion(companion);
    }

    public static void setHotel(Hotel hotel, Register register){
        register.setHotel(hotel);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Create a new participant
     * Pre: name not empty, city not empty, country not empty, phone number not negative, business name not empty, business phone number not negative
     * */
    public static Participant createParticipant(String name, String city, String country, int phoneNumber, String businessName, int businessPhoneNumber){
        Participant participant = new Participant(name, city, country, phoneNumber, businessName, businessPhoneNumber);
        Storage.storeParticipant(participant);
        return participant;
    }

    public static ArrayList<Participant> getParticipants(){
        return Storage.getParticipants();
    }

    public static Companion createCompanion(String name, Participant participant){
        return participant.createCompanion(name);
    }

    public static void chooseExcursion(Excursion excursion, Register register){
        register.getCompanion().addExcursions(excursion);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Create a new hotel
     * Pre: name not empty, single and double room price not negative
     * */

    public static Hotel createHotel(String name, double singleRoomPrice, double doubleRoomPrice){
        Hotel hotel = new Hotel(name, singleRoomPrice, doubleRoomPrice);
        Storage.storeHotel(hotel);
        return hotel;
    }

    public static ArrayList<Hotel> getHotels(){
        return Storage.getHotels();
    }


    public static void createExtra(String name, double price, Hotel hotel){
        hotel.createExtra(name, price);
    }

    public static void addExtra(Extra extra, Register register){
        register.addExtra(extra);
    }

    public static void rentHotelroom(Register register, Hotel hotel){
        hotel.rentHotelRoom(register);
        register.setHotel(hotel);
    }

    // -----------------------------------------------------------------------------------------------------------------

}
