package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import main.model.Car;
import main.repository.CarRepository;

@SpringBootApplication
public class SpringDataBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(SpringDataBootApplication.class, args);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));

        CarRepository carRepo = ctx.getBean(CarRepository.class);
        cars.forEach(carRepo::save);

        Car firstCar = carRepo.findById(1L).get();
        carRepo.delete(firstCar);

        carRepo.findAll().forEach(System.out::println);

        ctx.close();
    }
}