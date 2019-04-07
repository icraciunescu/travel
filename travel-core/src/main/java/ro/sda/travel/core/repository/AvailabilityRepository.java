package ro.sda.travel.core.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.travel.core.entity.Availability;

public interface AvailabilityRepository extends CrudRepository<Availability, Integer> {
}
