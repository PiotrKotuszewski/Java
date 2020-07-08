import AbstractClass.Rectangle;
import AbstractClass.Shape;
import AbstractClass.Triangle;
import Dynamic.AcademyPlayer;
import Dynamic.Player;
import MultiInheritance.PlayingCoach;
import Overlapping.Person;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String [] args){
        //abstractClass();
        //overlapping();
        //multiInheritance();
        multiAscept();
        //dynamic();
    }

    public static void abstractClass(){
        Shape triangle = new Triangle(5,3,4,2);
        triangle.area();
        triangle.perimeter();
        System.out.println(triangle.show());

        Shape rectangle = new Rectangle(5,4);
        rectangle.area();
        rectangle.perimeter();
        System.out.println(rectangle.show());
    }

    public static void overlapping(){
        Person person = new Person("Jan", "Nowak", LocalDate.of(1995,1,1), List.of("Doktor", "Magister"), "12345678901");

        try{
            System.out.println(person.hasDyploms());
            System.out.println(person.getPesel());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void multiInheritance(){
        PlayingCoach playingCoach = new PlayingCoach("Jan", "Nowak", LocalDate.of(1997,1,1), LocalDate.of(2021,5,5),50000F,"(4-4-2)", 23, 15000F, "Srodkowy Pomocnik Defensywny", 20000F);

        System.out.println(playingCoach);
    }

    public static void multiAscept(){

    }

    public static void dynamic(){
        Dynamic.Person person = new AcademyPlayer("Jan", "Kowalski", LocalDate.of(2000,1,1), "SPO", "SP", 2000f);
        System.out.println(person);
        System.out.println(person.getIncome());

        //Create Player based on AcademyPlayer
        person = new Player(person, "SPO", 7000F, 12000F);
        System.out.println(person);
        System.out.println(person.getIncome());

        Dynamic.Person person2 = new Player("Adam", "Nowak", LocalDate.of(1990,1,1), "SPO", 12000F, 50000F);
        System.out.println(person2);
        System.out.println(person2.getIncome());

        //Create AcademyPlayer based on Player
        person2 = new AcademyPlayer(person2, "RB", "SP", 2000F);
        System.out.println(person2);
        System.out.println(person2.getIncome());

    }
}
