package ro.sda.travel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.entity.Availability;
import ro.sda.travel.core.service.AvailabilityService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Path("/availability")
public class AvailabilityRestService {

    @Autowired
    private AvailabilityService availabilityService;

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Availability> findAll() {
        return availabilityService.getAllAvailability();
    }

    @Path("/find")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Availability>findAvailabilitiesByFromDateLessThanEqualAndToDateGreaterThanEqual(@QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate) throws ParseException {
        Date from = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
        Date to = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
        return availabilityService.findAvailabilitiesByFromDateLessThanEqualAndToDateGreaterThanEqual(from, to);
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Availability findById(@PathParam("id") int id) {
        return availabilityService.getAvailabilityById(id);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAvailability(@QueryParam("availabilityId") int id) {
        availabilityService.deleteAvailability(id);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Availability createAvailability(Availability availability) {
        return availabilityService.createAvailability(availability);
    }

}
