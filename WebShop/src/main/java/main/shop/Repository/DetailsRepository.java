package main.shop.Repository;

import main.shop.Model.Details;
import org.springframework.data.repository.CrudRepository;

public interface DetailsRepository extends CrudRepository<Details, Long> {
}
