package main;

import main.Model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static Client client = new Client("Jan", "Kowalski", LocalDate.of(2012, 1, 1), "12345678901", "511412851");
    private static Client client2 = new Client("Bartek", "Kowalski", LocalDate.of(2012, 1, 1), "12345678901", "511412851");

    public static void main(String [] args) throws Exception{
        simpleAssosciation();
        //assosciationWithParameter();
        //qualifedAssosciation();
        //compositionInternalClass();
    }

    public static void simpleAssosciation(){
        //Assosciation Team * ---- * Tournament

        Team team = new Team("Cardiff City");
        Team team2 = new Team("Nottingham Forest");

        Tournament tournament = new Tournament(LocalDate.of(2020,5,5), LocalDate.of(2020,6,5), 400000f);
        Tournament tournament2 = new Tournament(LocalDate.of(2020,7,5), LocalDate.of(2020,8,5), 400000f);

        team.addTournament(tournament);
        team.addTournament(tournament2);
        team2.addTournament(tournament);

        System.out.println(team);
        System.out.println(tournament);

    }

    public static void assosciationWithParameter() {
        //Assosciation with parameter Client to Visit
        Visit visit = new Visit(150, "15:30", "16:00");
        ClientVisit clientVisit = new ClientVisit(LocalDate.of(2020, 1, 5), client, visit);
        ClientVisit clientVisit1 = new ClientVisit(LocalDate.of(2020, 1, 10), client, visit);

        client.addClientVisit(clientVisit);
        client.addClientVisit(clientVisit1);

        visit.addClientVisit(clientVisit);
        visit.addClientVisit(clientVisit1);


        System.out.println(clientVisit);
        System.out.println(client.getClientVisits());
    }

    public static void qualifedAssosciation()throws Exception {
        List<String> dyploms = new ArrayList<>();
        dyploms.add("Magister");
        dyploms.add("Doktor");

        //Qualified association Dentis * to 1 Duty
        Dentist dentist = new Dentist("Jan", "Kowal", LocalDate.of(2020, 1, 1), "12345678901", dyploms);
        Dentist dentist2 = new Dentist("Jaroslaw", "Duda", LocalDate.of(2020, 1, 1), "12345678901", dyploms);

        Duty duty = new Duty(LocalDate.of(2020, 2, 1));
        Duty duty2 = new Duty(LocalDate.of(2020, 2, 5));
        Duty duty3 = new Duty(LocalDate.of(2020, 2, 7));

        dentist.addDutiesQualif(duty);
        dentist2.addDutiesQualif(duty);
        dentist2.addDutiesQualif(duty3);

        System.out.println(dentist);
        System.out.println(dentist2);

        Duty findDuty = dentist.findDutyQualif(LocalDate.of(2020, 2, 1));
        System.out.println(findDuty);
    }

    public static void compositionInternalClass() {
        Treatment treatment = new Treatment("Duza");
        treatment.createTool("Skalpel", 0.3);
        treatment.createTool("Protetyk", 1.0);

        Treatment.Tool tool = treatment.new Tool("Protetyk", 1.0);

        System.out.println(treatment);
        System.out.println(tool);
    }
}
