package ro.sda.travel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel.core.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
