package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.controller.RatingController;
import ro.sda.travel.core.entity.Rating;

@Service
public class RatingService {

    @Autowired
    private RatingController ratingController;

    public Rating createRating(Rating rating) {
        return ratingController.createRating(rating);
    }
}
