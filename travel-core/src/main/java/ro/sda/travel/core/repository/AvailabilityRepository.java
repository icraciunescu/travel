package ro.sda.travel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel.core.entity.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
}

