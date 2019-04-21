package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.commons.EmailService;
import ro.sda.travel.core.controller.AvailabilityController;
import ro.sda.travel.core.entity.Availability;
import ro.sda.travel.core.entity.Booking;
import ro.sda.travel.core.enums.RoomType;
import ro.sda.travel.core.repository.BookingRepository;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private AvailabilityController availabilityController;

    private EmailService emailService = new EmailService();


    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(int id) {
        return bookingRepository.findOne(id);
    }

    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    public Booking updateBooking(Booking booking) {
        Booking bookingFromDb = bookingRepository.findOne(booking.getId());
        return bookingRepository.save(bookingFromDb);
    }

    public void deleteBooking(int id) {
        bookingRepository.delete(id);
    }

    public void sendBookingMail(Booking booking, Availability availability) {
        String message = "Dear " + booking.getClient().getName() + "\n" + "Thank you for choosing "
                + booking.getProperty().getName() + ". According to your order, we make a reservation for you as following:"
                + "\n" + "-" + booking.getNumberOfRooms() + " room(s) "
                + "\n" + booking.getRoomType()
                + "\n" + " check-in date: " + booking.getCheckIn()
                + "\n" + " check-out date: " + booking.getCheckOut()
                + "\n" + "price: " + getIntervalBetweenTwoDates(booking.getCheckIn(), booking.getCheckOut()) *
                getRoomPrice(availability, booking) + " RON."
                + "\n" + " We are looking forward to have you our guest!";
        String eMail = booking.getClient().getEmail();
        String subject = "Room reservation for " + booking.getClient().getName();
        int size = availabilityController.findAvailabilitiesByFromDateLessThanEqualAndToDateGreaterThanEqual(booking.getCheckIn(), booking.getCheckOut()).size();
        if (size == 0) {
            String nonAvailabilityMessage = "Sorry, but we don't have available rooms in the period you chose.";
            emailService.sendEmail(nonAvailabilityMessage, eMail, subject);
        } else {
            emailService.sendEmail(message, eMail, subject);
        }
    }

    public Long getIntervalBetweenTwoDates(Date firstDate, Date secondDate) {
        Long diff = secondDate.getTime() - firstDate.getTime();
        Long diffDays = diff / (60 * 60 * 1000 * 24);
        return diffDays;
    }

    public Integer getRoomPrice(Availability availability, Booking booking) {
        Integer price = null;
        if (booking.getRoomType().equals(String.valueOf(RoomType.SINGLE))) {
            price = availability.getPriceSingle();
        } else {
            price = availability.getPriceDouble();
        }
        return price;
    }

}