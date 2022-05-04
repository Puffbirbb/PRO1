package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Register {

    private LocalDate arrival;
    private LocalDate departure;
    private boolean lecturer;

    // Aggregering 1 - 0.*, Conference not nullable, package visible
    Conference conference;

    private ArrayList<Extra> chosenExtras = new ArrayList<>();
    // association --> 0..1 Hotel
    Hotel hotel; //OBS: package visible

    private Participant participant;
    private Companion companion;

    public Register(LocalDate arrival, LocalDate departure, boolean lecturer, Participant participant, Conference conference){
        this.arrival = arrival;
        this.departure = departure;
        this.lecturer = lecturer;
        this.participant = participant;
        this.conference = conference;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public boolean isLecturer() {
        return lecturer;
    }

    public Conference getConference() {
        return conference;
    }

    /**
     * Pre: The extra is not connected to a register.
     */
    public void addExtra(Extra extra){
        chosenExtras.add(extra);
    }

    /**
     * Pre: The extra is not connected to a register.
     */
    public void removeExtra(Extra extra){
        chosenExtras.remove(extra);
    }

    /**
     * Note: Nullable return value.
     */
    public Hotel getHotel() {
        return hotel;
    }

    public Participant getParticipant() {
        return participant;
    }

    public Companion getCompanion() {
        return companion;
    }

    public void setCompanion(Companion companion) {
        this.companion = companion;
        companion.participant = participant;
    }

    public long getDays(){
        long days = 0;
        days = ChronoUnit.DAYS.between(arrival, departure);
        return days+1;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
        hotel.addRegister(this);
    }

    public ArrayList<Extra> getChosenExtras() {
        return chosenExtras;
    }

    public double calculateParticipantPrice(Hotel hotel) {
        double p = 0;
        for (int i = 0; i < chosenExtras.size(); i++){
            p = p + chosenExtras.get(i).getPrice()*(getDays()-1);
        }
        p = p + hotel.rentHotelRoom(this)*(getDays()-1);
        if (getCompanion() != null){
            for (Excursion excursion : companion.getExcursions()){
                p = p + excursion.getPrice();
            }
        }
        if (isLecturer() == false) {
            p = p + conference.getPrice()*(getDays());
        }
        return p;
    }

    public double calculateParticipantPrice() {
        double p = 0;
        if (getCompanion() != null){
            for (Excursion excursion : companion.getExcursions()){
                p = p + excursion.getPrice();
            }
        }
        p = p + conference.getPrice()*(getDays());
        return p;
    }

    @Override
    public String toString() {
        return "Participant: {" +
                "name: " + participant.getName() +
                ", phonenumber: " + participant.getPhoneNumber() +
                ", Arrival: " + arrival +
                ", depature: " + departure + (isLecturer() ? ", Lecturer" : "") +
                '}';
    }

}
