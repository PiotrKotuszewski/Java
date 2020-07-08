import AttributeConstraints.Truck;
import AttributeConstraints.User;
import BagConstraints.PlayerTraining;
import BagConstraints.Training;
import SubsetAndOrderedConstraints.Player;
import SubsetAndOrderedConstraints.Team;
import XorConstraints.PersonType;

import java.time.LocalDate;

public class Main {
    public static void main(String [] args) throws Exception {
        //attribute();
        //unique();
        //subset();
        //bag();
        //xor();
    }

    public static void attribute() throws Exception {
        //dynamic
        User user = new User();
        user.setUsername("abc");
        user.setPassword("aa");
        System.out.println(user);

        //static
        Truck truck = new Truck(12000f, "WE4124");
        truck.setCapacity(500f);
        System.out.println(truck);
    }

    public static void unique(){
        // Numer koszulki nie moze sie powtarzac
        // Imie i nazwisko musza zaczynac sie z duzej litery, moga zawierac tylko litery i maja ograniczona dlugosc
        UniqueAndOwnConstraints.Player player = new UniqueAndOwnConstraints.Player("Jan", "Nowaka", "SP", 8);
        UniqueAndOwnConstraints.Player player2 = new UniqueAndOwnConstraints.Player("Piotr", "Dudaaaa","SP", 10);

        player.setFirstName("asier");
        player.setLastName("Illarramendi");
        System.out.println(player.toString());
        System.out.println(player2.toString());

        player2.setShirtNumber(11);
        System.out.println(player2);

       // System.out.println(UniqueAndOwnConstraints.Player.getNumbers());

    }

    public static void subset() {
        // Rowniez {ordered} poniewaz lista pilkarzy w kolejnosci dodania, przy uzyciu Vector
        Team team = new Team("Cardiff City");
        Player player = new Player("Jan", "Nowak", LocalDate.of(2000,1,1), "SP");
        Player player2 = new Player("Piotr", "Duda", LocalDate.of(2000,1,1), "SP");
        Player playe3 = new Player("Asier", "Mayoral", LocalDate.of(2000,1,1), "SP");
        Player player54 = new Player("Sergio", "Baggio", LocalDate.of(2000,1,1), "SP");
        try {
            team.addPlayer(player);
            team.addPlayer(player2);
            team.addPlayer(playe3);
            team.addPlayer(player54);
            team.setCapitan(player2);

            System.out.println(team.getMembers());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bag(){
        BagConstraints.Player player = new BagConstraints.Player(7, "LW");

        Training training = new Training(1.5f, "Shooting training");

        PlayerTraining playerTraining = new PlayerTraining(LocalDate.of(2020,6,1), training, player);
        PlayerTraining playerTraining2 = new PlayerTraining(LocalDate.of(2020,6,4), training, player);

        player.addPlayerTraining(playerTraining);
        player.addPlayerTraining(playerTraining2);

        training.addPlayerTraining(playerTraining);
        training.addPlayerTraining(playerTraining2);

        System.out.println(PlayerTraining.getPlayerTraining(player));
    }

    public static void xor(){
        //Jesli osoba jest Zawodnikiem to nie moze byc Arbitrem i na odwrot
        XorConstraints.Person person = new XorConstraints.Person("Jan", "Nowak", LocalDate.of(1990,1,1), 5000F, PersonType.Player);
        XorConstraints.Person person2 = new XorConstraints.Person("Bartek", "Duda", LocalDate.of(1980,1,1), 2000F, PersonType.Arbiter);

        System.out.println(person2);
    }
}
