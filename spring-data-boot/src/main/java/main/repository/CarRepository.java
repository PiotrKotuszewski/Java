package main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}