package gui;

import controller.Controller;
import javafx.application.Application;
import model.*;
import storage.Storage;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        initStorage();
        Application.launch(GuiHomePage.class);
    }

    public static void initStorage() {
        Organisation o1 = Controller.createOrganisation("Miljøorganisation");

        Conference c1 = Controller.createConference("Hav og Himmel", "Sønderhøj 30", 1500,"Hoved Sal", o1);
        Conference c2 = Controller.createConference("Morderne Vindmølleparker", "Sønderhøj 30", 1500,"Hoved Sal", o1);
        Conference c3 = Controller.createConference("Atomkraft", "Sønderhøj 30", 1500,"Hoved Sal", o1);


        Hotel h1 = Controller.createHotel("Den Hvide Svane", 1050, 1250);
        Controller.createExtra("WIFI",50, h1);
        Controller.addHotel(h1, c1);

        Hotel h2 = Controller.createHotel("Hotel Phønix", 700, 800);
        Controller.createExtra("Bad",200, h2);
        Controller.createExtra("WIFI",75, h2);
        Controller.addHotel(h2, c1);

        Hotel h3 = Controller.createHotel("Pension Tusindfryd", 500, 600);
        Controller.createExtra("Mad",100, h3);
        Controller.addHotel(h3, c1);

        Controller.createExcursion("Byrundtur Odense", LocalDate.of(2021, 12, 18),125, c1);
        Controller.createExcursion("Egeskov", LocalDate.of(2021, 12, 19),75, c1);
        Controller.createExcursion("Trapholt Museum, Kolding", LocalDate.of(2021, 12, 20),200, c1);

        Participant p1 = Controller.createParticipant("Finn Madsen", "Aarhus", "DK", 1231231, "Miljø og teknik", 123123123);
        Register r1 = Controller.createRegister(LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), false, p1, c1);
        Controller.rentHotelroom(r1, h1);


        Participant p2 = Controller.createParticipant("Niels Petersen", "Herning", "DK", 1231231, "Mærsk", 123123123);
        Register r2 = Controller.createRegister(LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), false, p2, c1);
        Controller.rentHotelroom(r2, h1);

        Participant p3 = Controller.createParticipant("Ulla Hansen", "Esbjerg", "Da", 1231231, "Ørsted", 123123123);
        Companion com1 = Controller.createCompanion("Hans Hansen", p3);
        Register r3 = Controller.createRegister(LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 19), false, p3, c1);
        Controller.setCompanion(com1, r3 ); // Controller?
        Controller.chooseExcursion(c1.getExcursions().get(0), r3);

        Participant p4 = Controller.createParticipant("Peter Sommer", "Odense", "Da", 1231231, "Fiskerimusseet", 123123123);
        Companion com2 = p4.createCompanion("Mie Sommer");
        Register r4 = Controller.createRegister(LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), false, p4, c1);
        Controller.setCompanion(com2, r4);
        Controller.chooseExcursion(c1.getExcursions().get(1), r4);
        Controller.chooseExcursion(c1.getExcursions().get(2), r4);
        Controller.rentHotelroom(r4, h1);
        Controller.addExtra(h1.getExtras().get(0), r4);

        Participant p5 = Controller.createParticipant("Lone Jensen", "Ballerup", "DK", 1231231, "", 123123123);
        Companion com3 = Controller.createCompanion("Jan Madsen", p5);
        Register r5 = Controller.createRegister(LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), true, p5, c1);
        Controller.setCompanion(com3, r5);
        Controller.chooseExcursion(c1.getExcursions().get(0), r5);
        Controller.chooseExcursion(c1.getExcursions().get(1), r5);
        Controller.rentHotelroom(r5, h1);
        Controller.addExtra(h1.getExtras().get(0), r5);
    }
}