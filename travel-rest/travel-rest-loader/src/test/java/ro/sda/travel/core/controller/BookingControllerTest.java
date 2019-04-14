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
import ro.sda.travel.core.entity.Booking;
import ro.sda.travel.core.entity.Payment;
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


    @Test
    @Rollback(false)
    public void testCreate() {
        Booking booking = new Booking();
        booking.setClient(clientController.getClientById(1));
        booking.setProperty(propertyController.getPropertyById(1));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019, 07, 15);
        Date date = calendar.getTime();
        booking.setCheckIn(date);
        calendar.set(2019, 07, 25);
        Date date1 = calendar.getTime();
        booking.setCheckOut(date1);
        booking.setNrOfPersons(2);
        booking.setRoomType(RoomType.DOUBLE);
        booking.setNumberOfRooms(1);
        calendar.set(2019, 04, 13);
        Date date2 = calendar.getTime();
        booking.setBookingData(date2);

        bookingController.createBooking(booking);
        System.out.println(booking.toString());
        Assert.assertNotNull(booking);
    }

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
        booking.setRoomType(RoomType.SINGLE);
        System.out.println(booking.toString());
        List<Booking> bookings1 = bookingController.getAllBooking();
        int expected = bookings.size();
        Assert.assertEquals(expected, actual + 1);

    }

    @Test
    @Rollback
    public void testUpdate() {
        Booking bookingFromDB = bookingController.getBookingById(11);
        bookingFromDB.setRoomType(RoomType.SINGLE);
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
        Booking booking= bookingController.getBookingById(11);
        bookingController.deleteBooking(11);
        Assert.assertNotNull(booking);
    }
}
