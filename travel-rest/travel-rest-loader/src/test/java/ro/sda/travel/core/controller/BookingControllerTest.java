package ro.sda.travel.core.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.travel.core.entity.Availability;
import ro.sda.travel.core.entity.Booking;
import ro.sda.travel.core.enums.RoomType;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class BookingControllerTest {

    @Autowired
    @Qualifier("bookingController")
    public BookingController bookingController;

    @Autowired
    @Qualifier("clientController")
    public ClientController clientController;

    @Autowired
    @Qualifier("propertyController")
    public PropertyController propertyController;

    @Autowired
    @Qualifier("availabilityController")
    public AvailabilityController availabilityController;

    @Test
    @Rollback(false)
    public void testCreate() {

        Booking booking = new Booking();
        booking.setClient(clientController.getClientById(1));
        booking.setProperty(propertyController.getPropertyById(1));
        booking.setAvailability(availabilityController.getAvailabilityById(1));
        Availability availability = availabilityController.getAvailabilityById(1);
        int availabilityId = availability.getId();
        System.out.println(availabilityId);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019, Calendar.AUGUST, 20);
        Date date = calendar.getTime();
        booking.setCheckIn(date);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(0);
        calendar1.set(2019, Calendar.AUGUST, 23);
        Date date1 = calendar1.getTime();
        booking.setCheckOut(date1);

        booking.setNrOfPersons(2);
        booking.setRoomType(RoomType.DOUBLE);
        booking.setNumberOfRooms(1);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(0);
        calendar2.set(2019, Calendar.JULY, 15);
        Date date2 = calendar.getTime();
        booking.setBookingData(date2);

        bookingController.createBooking(booking);

        Availability availability1 = new Availability();
        Availability availability2 = new Availability();

        availability1.setFromDate(availability.fromDate);
        availability1.setPriceDouble(availability.getPriceDouble());
        availability1.setPriceSingle(availability.getPriceSingle());
        availability1.setRoomName(availability.getRoomName());
        availability1.setRoomType(availability.getRoomType());
        availability1.setToDate(date);
        availability1.setProperty(availability.getProperty());

        availabilityController.createAvailability(availability1);

        availability2.setFromDate(date1);
        availability2.setPriceDouble(availability.getPriceDouble());
        availability2.setPriceSingle(availability.getPriceSingle());
        availability2.setRoomName(availability.getRoomName());
        availability2.setRoomType(availability.getRoomType());
        availability2.setToDate(availability.toDate);
        availability2.setProperty(availability.getProperty());

        availabilityController.createAvailability(availability2);

        availabilityController.deleteAvailability(availabilityId);

        System.out.println(booking.toString());
        Assert.assertNotNull(booking);

    }


//    @Test
//    @Rollback(false)
//    public void testCreate() {
//
//        Booking booking = new Booking();
//        booking.setClient(clientController.getClientById(1));
//        booking.setProperty(propertyController.getPropertyById(1));
//        booking.setAvailability(availabilityController.getAvailabilityById(1));
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(0);
//        calendar.set(2019, Calendar.AUGUST, 20);
//        Date date = calendar.getTime();
//        booking.setCheckIn(date);
//
//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.setTimeInMillis(0);
//        calendar1.set(2019, Calendar.AUGUST, 23);
//        Date date1 = calendar1.getTime();
//        booking.setCheckOut(date1);
//
//        booking.setNrOfPersons(2);
//        booking.setRoomType(RoomType.DOUBLE);
//        booking.setNumberOfRooms(1);
//
//        Calendar calendar2 = Calendar.getInstance();
//        calendar2.setTimeInMillis(0);
//        calendar2.set(2019, Calendar.JULY, 15);
//        Date date2 = calendar.getTime();
//        booking.setBookingData(date2);
//
//        bookingController.createBooking(booking);
//        System.out.println(booking.toString());
//        Assert.assertNotNull(booking);
//    }

    @Test
    @Rollback(false)
    public void testRead() {
        Booking booking = bookingController.getBookingById(1);
        int actual = booking.getId();
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testReadAll() {
        List<Booking> bookings = bookingController.getAllBooking();
        int actual = bookings.size();
        Booking booking = new Booking();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019, 3, 28);
        Date date = calendar.getTime();
        booking.setBookingData(date);
        bookingController.createBooking(booking);
        calendar.setTimeInMillis(0);
        calendar.set(2019, 4, 28);
        Date date1 = calendar.getTime();
        booking.setCheckIn(date1);
        calendar.setTimeInMillis(0);
        calendar.set(2019, 5, 28);
        Date date2 = calendar.getTime();
        booking.setCheckOut(date2);
        booking.setClient(clientController.getClientById(1));
        booking.setNrOfPersons(2);
        booking.setProperty(propertyController.getPropertyById(2));
        booking.setNumberOfRooms(2);
        booking.setRoomType(RoomType.DOUBLE);
        System.out.println(booking.toString());
        List<Booking> bookings1 = bookingController.getAllBooking();
        int expected = bookings.size();
        Assert.assertEquals(expected, actual + 1);
    }

    @Test
    @Rollback
    public void testUpdate() {
        Booking bookingFromDB = bookingController.getBookingById(11);
        bookingFromDB.setRoomType(RoomType.DOUBLE);
        bookingFromDB.setNumberOfRooms(2);
        bookingFromDB.setNrOfPersons(3);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019, 02, 28);
        Date date = calendar.getTime();
        bookingFromDB.setCheckOut(date);
        calendar.setTimeInMillis(0);
        calendar.set(2019, 06, 28);
        Date date1 = calendar.getTime();
        bookingFromDB.setBookingData(date1);
        System.out.println(bookingController.toString());

        Booking expected = bookingController.updateBooking(bookingFromDB);
        Booking actual = bookingFromDB;
        Assert.assertEquals(expected, actual);
    }
    @Test
    @Rollback
    public void testDelete(){
        bookingController.deleteBooking(2);
        Booking booking= bookingController.getBookingById(2);
        Assert.assertNotNull(booking);
    }

    @Test
    @Rollback(false)
    @Transactional

    public void sendBookingMailTest(){
        Availability availability = availabilityController.getAvailabilityById(1);
        Booking booking = bookingController.getBookingById(1);
        bookingController.sendBookingMail(booking,availability);
    }
}
