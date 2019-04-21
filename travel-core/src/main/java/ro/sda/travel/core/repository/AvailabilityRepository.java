package ro.sda.travel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel.core.entity.Availability;
import java.util.Date;
import java.util.List;


public interface AvailabilityRepository extends JpaRepository<Availability, Integer>  {

    List<Availability> findAvailabilitiesByFromDateLessThanEqualAndToDateGreaterThanEqual(Date fromDate, Date toDate);

}



