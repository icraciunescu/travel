package ro.sda.travel.core.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.travel.core.entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
}
