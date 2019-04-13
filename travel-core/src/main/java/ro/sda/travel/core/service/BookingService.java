package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.entity.Booking;
import ro.sda.travel.core.repository.BookingRepository;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(int id) {
        return bookingRepository.findOne(id);
    }

    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    public void deleteBooking(int id) {
        bookingRepository.delete(id);
    }
}
