import Model.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String [] args) {
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;

        //Client 1---* Tooth
        Client client = new Client("Adam", "Nowak", LocalDate.of(2020,1,1), "123123131", "12312313");
        Client client2 = new Client("Adam", "Nowak", LocalDate.of(2020,1,1), "123123131", "12312313");

        Tooth tooth = new Tooth("good", "white", 5);
        client.addTooth(tooth);

        //Dentist i Client dziedzicza po abstrakcyjnej klasie Person
        Dentist dentist = new Dentist("Adam", "Skalpel",LocalDate.of(1990,1,1), "karta", 5);
        Dentist dentist2 = new Dentist("Adam", "Skalpel",LocalDate.of(1990,1,1), "karta", 5);

        //Dentist 1---* Duty
        Duty duty = new Duty(LocalDate.of(2020,5,5), 8, 10);
        Duty duty2 = new Duty(LocalDate.of(2020,5,6), 7, 8);
        dentist.addDuty(duty);
        dentist.addDuty(duty2);

        Secretary secretary = new Secretary("Ada", "Duda", LocalDate.of(1996,1,1), LocalDate.of(2019,1,1), 2500);


      //  Visit visit = new Visit(LocalDate.of(2020,5,5), 15.0, 15.3, 200.0, true);
      //  visit.addClient(client);*/


        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            /*session.save(client);
            session.save(client2);
            session.save(tooth);
            session.save(dentist);
            session.save(dentist2);
            session.save(duty);
            session.save(duty2);
            session.save(secretary);*/
            //session.save(visit);

            session.getTransaction().commit();
            session.close();

            session = sessionFactory.openSession();
            session.beginTransaction();

            List<Dentist> dentistsFromDb = session.createQuery( "from dentist " ).list();
            for (Dentist dentists : dentistsFromDb) {
                System.out.println(dentists);
            }

            List<Duty> dutiesFromDb = session.createQuery(" from duty" ).list();
            for(Duty duties : dutiesFromDb){
                System.out.println(duties);
            }

            List<Client> clientsFromDb = session.createQuery(" from client").list();
            for(Client clients : clientsFromDb){
                System.out.println(clients);
            }

            List<Duty> duties = dentist.getDuties();
            for(Duty duty1: duties)
                System.out.println(duty1.getDentist());
         //   List<Object> clientVisitFromDb = session.createQuery("from client_visit").list();

            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
        finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
