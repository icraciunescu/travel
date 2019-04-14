package ro.sda.travel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.entity.Rating;
import ro.sda.travel.core.service.RatingService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/rating")
public class RatingRestService {

    @Autowired
    private RatingService ratingService;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rating> findAll() {
        return ratingService.getAllRating();
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Rating findById(@PathParam("id") int id) {
        return ratingService.getRatingById(id);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteRating(@QueryParam("deleteId") int id) {
        ratingService.deleteRating(id);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Rating createRating(Rating rating) {
        return ratingService.createRating(rating);
    }

}
