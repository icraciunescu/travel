package ro.sda.travel.core.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.travel.core.entity.Property;

public interface PropertyRepository extends CrudRepository<Property, Integer> {
}
