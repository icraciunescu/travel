package ro.sda.travel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.commons.EmailService;
import ro.sda.travel.core.entity.Booking;
import ro.sda.travel.core.service.BookingService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Path("/booking")
public class BookingRestService {

    @Autowired
    private BookingService bookingService;

    EmailService emailService = new EmailService();

    @Path("/find-all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Booking> findAll() {
        return bookingService.getAllBooking();
    }

    @Path("/find/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Booking findById(@PathParam("id") int id) {
        return bookingService.getBookingById(id);
    }

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteBooking(@QueryParam("bookingId") int id) {
        bookingService.deleteBooking(id);
    }

    @Path("/create")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Booking createBooking(Booking booking) {
        Booking bookingDone = bookingService.createBooking(booking);
        emailService.sendEmail("booking confirmation", "java2Iasi@gmail.com", "Booking details");
        return bookingDone;
    }
}
