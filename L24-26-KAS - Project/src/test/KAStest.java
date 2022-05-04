package test;

import model.*;

import java.time.LocalDate;

public class KAStest {
    public static void main(String[] args) {
        Organisation O1 = new Organisation("tpg");

        O1.createConference("Hav og Himmel", "Sønderhøj 30", 1500,"Hoved Sal");

        Hotel H1 = new Hotel("Den Hvide Svane", 1050, 1250);
        H1.createExtra("WIFI",50);
        Hotel H2 = new Hotel("Hotel Phønix", 700, 800);
        H2.createExtra("Bad",200);
        H2.createExtra("WIFI",75);
        Hotel H3 = new Hotel("Pension Tusindfryd", 500, 600);
        H3.createExtra("Mad",100);

        O1.getConferences().get(0).createExcursion("Byrundtur Odense", LocalDate.of(2021, 12, 18),125);
        O1.getConferences().get(0).createExcursion("Egeskov", LocalDate.of(2021, 12, 19),75);
        O1.getConferences().get(0).createExcursion("Trapholt Museum, Kolding", LocalDate.of(2021, 12, 20),200);

        Participant P1 = new Participant("Finn Madsen", "Ba", "Da", 1231231, "Dasd", 123123123);
        Register R1 = new Register(LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), false, P1, O1.getConferences().get(0));
        H1.rentHotelRoom(R1);

        Participant P2 = new Participant("Niels Petersen", "Ba", "Da", 1231231, "Dasd", 123123123);
        Register R2 = new Register(LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), false, P2, O1.getConferences().get(0));
        R1.setHotel(H1);
        H1.rentHotelRoom(R2);

        Participant P3 = new Participant("Ulla Hansen", "Ba", "Da", 1231231, "Dasd", 123123123);
        P3.createCompanion("Hans Hansen");
        P3.getCompanions().get(0).addExcursions(O1.getConferences().get(0).getExcursions().get(0));
        Register R3 = new Register(LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 19), false, P3, O1.getConferences().get(0));
        R3.setCompanion(P3.getCompanions().get(0));

        Participant P4 = new Participant("Peter Sommer", "Ba", "Da", 1231231, "Dasd", 123123123);
        P4.createCompanion("Mie Sommer");
        P4.getCompanions().get(0).addExcursions(O1.getConferences().get(0).getExcursions().get(1));
        P4.getCompanions().get(0).addExcursions(O1.getConferences().get(0).getExcursions().get(2));
        Register R4 = new Register(LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), false, P4, O1.getConferences().get(0));
        R4.setCompanion(P4.getCompanions().get(0));
        R4.setHotel(H1);
        H1.rentHotelRoom(R4);
        R4.addExtra(H1.getExtras().get(0));

        Participant P5 = new Participant("Lone Jensen", "Ba", "Da", 1231231, "Dasd", 123123123);
        P5.createCompanion("Jan Madsen");
        P5.getCompanions().get(0).addExcursions(O1.getConferences().get(0).getExcursions().get(0));
        P5.getCompanions().get(0).addExcursions(O1.getConferences().get(0).getExcursions().get(1));
        Register R5 = new Register(LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), true, P5, O1.getConferences().get(0));
        R5.setCompanion(P5.getCompanions().get(0));
        R5.setHotel(H1);
        H1.rentHotelRoom(R5);
        R5.addExtra(H1.getExtras().get(0));


        System.out.println(P1.getName() + ": ");
        System.out.println(R1.calculateParticipantPrice());
        //System.out.println(R1.get);
        System.out.println(P2.getName() + ": ");
        System.out.println(R2.calculateParticipantPrice(H1));
       // System.out.println(R2);
        System.out.println(P3.getName());
        System.out.println(R3.calculateParticipantPrice());
        //System.out.println(R3);

        System.out.println(P4.getName());
        System.out.println(R4.calculateParticipantPrice(H1));
        //System.out.println(R4);

        System.out.println(P5.getName() + ": ");
        System.out.println(R5.calculateParticipantPrice(H1));
        //System.out.println(R5);
    }
}
