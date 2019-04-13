package ro.sda.travel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel.core.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
