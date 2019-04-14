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
import ro.sda.travel.core.enums.RoomType;

import java.util.Calendar;
import java.util.Date;

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
        booking.setClient(clientController.getClientById(15));
        booking.setProperty(propertyController.getPropertyById(1));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019,07,15);
        Date date = calendar.getTime();
        booking.setCheckIn(date);
        calendar.set(2019,07,25);
        Date date1 = calendar.getTime();
        booking.setCheckOut(date1);
        booking.setNrOfPersons(2);
        booking.setRoomType(RoomType.DOUBLE);
        booking.setNumberOfRooms(1);
        calendar.set(2019,04,13);
        Date date2 = calendar.getTime();
        booking.setBookingData(date2);

        bookingController.createBooking(booking);
        Assert.assertNotNull(booking);
    }

    @Test
    @Rollback(false)
    public void testRead() {
        Booking booking = bookingController.getBookingById(1);
        int actual = booking.getId();
        int expected = 1;
        Assert.assertEquals(expected,actual);
    }
}
