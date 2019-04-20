package ro.sda.travel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel.core.entity.Availability;

import java.util.Date;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer>  {

    List<Availability> findAvailabilitiesByFromDateGreaterThanEqualAndToDateLessThanEqual(Date fromDate, Date toDate);

    boolean existsAvailabilitiesByFromDateGreaterThanEqualAndToDateLessThanEqual(Date fromDate, Date toDate);

    List<Availability> getAvailabilitiesByFromDateEndingWithAndToDateIsAfter(Date fromDate, Date toDate);
}


