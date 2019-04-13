package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.entity.Rating;
import ro.sda.travel.core.repository.RatingRepository;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating getRatingById(int id) {
        return ratingRepository.findOne(id);
    }

    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    public void deleteRating(int id) {
        ratingRepository.delete(id);
    }
}
