package ro.sda.travel.core.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.travel.core.entity.Rating;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
}
