package model;

import java.util.ArrayList;

public class Organisation {
    private String name;

    //komposition 1 -> 0..*
    private ArrayList<Conference> conferences = new ArrayList<>();


    public Organisation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Conference> getConferences() {
        return conferences;
    }

    /**
     * Pre: The conference is not connected to an organisation
     *      price is positive.
     */

    public Conference createConference(String name, String adress, double price, String room){
        Conference conference = new Conference(name, adress, price, room);
        conferences.add(conference);
        return conference;
    }
}
