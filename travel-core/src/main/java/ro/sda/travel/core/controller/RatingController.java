package ro.sda.travel.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.travel.core.entity.Rating;
import ro.sda.travel.core.service.RatingService;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;


    public Rating createRating(Rating rating) {
        return ratingService.createRating(rating);
    }
}
