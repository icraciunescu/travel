package ro.sda.travel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel.core.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
