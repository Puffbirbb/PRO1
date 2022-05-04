package storage;
import model.*;

import java.util.ArrayList;

public class Storage {

    private static final ArrayList<Organisation> organisations = new ArrayList<>();
    private static final ArrayList<Conference> conferences = new ArrayList<>();
    private static final ArrayList<Register> registers = new ArrayList<>();
    private static final ArrayList<Participant> participants = new ArrayList<>();
    private static final ArrayList<Hotel> hotels = new ArrayList<>();

    // -------------------------------------------------------------------------

    public static ArrayList<Organisation> getOrganisations() {return new ArrayList<>(organisations);};

    public static void storeOrganisation(Organisation organisation){organisations.add(organisation);};

    public static void deleteOrganisation(Organisation organisation){organisations.remove(organisation);};

    // -------------------------------------------------------------------------

    public static ArrayList<Conference> getConferences() {return new ArrayList<>(conferences);};

    public static void storeConference(Conference conference){conferences.add(conference);};

    public static void deleteConference(Conference conference){conferences.remove(conference);};

    // -------------------------------------------------------------------------

    public static ArrayList<Register> getRegisters() {return new ArrayList<>(registers);};

    public static void storeRegister(Register register){registers.add(register);};

    public static void deleteRegister(Register register){registers.remove(register);};

    // -------------------------------------------------------------------------

    public static ArrayList<Participant> getParticipants() {return new ArrayList<>(participants);};

    public static void storeParticipant(Participant participant){participants.add(participant);};

    public static void deleteParticipant(Participant participant){participants.remove(participant);};


    // -------------------------------------------------------------------------

    public static ArrayList<Hotel> getHotels() {return new ArrayList<>(hotels);};

    public static void storeHotel(Hotel hotel){hotels.add(hotel);};

    public static void deleteHotel(Hotel hotel){hotels.remove(hotel);};


}

