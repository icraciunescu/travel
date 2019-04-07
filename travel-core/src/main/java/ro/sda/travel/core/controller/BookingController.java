package ro.sda.travel.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.travel.core.entity.Booking;
import ro.sda.travel.core.service.BookingService;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    public Booking createBooking(Booking booking) {
        return bookingService.createBooking(booking);
    }
}
