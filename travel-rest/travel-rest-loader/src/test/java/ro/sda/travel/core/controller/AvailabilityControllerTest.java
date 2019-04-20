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
import ro.sda.travel.core.enums.RoomType;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class AvailabilityControllerTest {

    @Autowired
    @Qualifier("availabilityController")
    public AvailabilityController availabilityController;

    @Autowired
    @Qualifier("hostController")
    public HostController hostController;

    @Autowired
    @Qualifier("propertyController")
    public PropertyController propertyController;

    @Test
    @Rollback(false)
    @Transactional
    public void testCreate() {

        Availability availability = new Availability();
        availability.setProperty(propertyController.getPropertyById(1));
        availability.setRoomName("nr 3");

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019, Calendar.AUGUST, 18);
        Date fromDate = calendar.getTime();
        availability.setFromDate(fromDate);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(0);
        calendar1.set(2019, Calendar.AUGUST, 28);
        Date toDate = calendar1.getTime();
        availability.setToDate(toDate);

        availability.setRoomType(RoomType.DOUBLE);
        System.out.println(RoomType.DOUBLE);
        availability.setPriceDouble(200);
        availability.setPriceSingle(100);

        System.out.println(availability.toString());
        availabilityController.createAvailability(availability);
        Assert.assertNotNull(availability);

    }

    @Test
    @Rollback(false)
    public void testRead() {
        Availability availability = availabilityController.getAvailabilityById(2);
        int actual = availability.getId();
        int expected = 2;
        System.out.println(availability.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testReadAll() {
        List<Availability> availabilities = availabilityController.getAllAvailability();
        int actual = availabilities.size();
        Availability availability = new Availability();
        availability.setProperty(propertyController.getPropertyById(1));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019, 3, 28);
        Date date = calendar.getTime();
        availability.setFromDate(date);
        availability.setRoomName("gwsgfusfjsfhjsfh");
        availability.setRoomType(RoomType.DOUBLE);
        availability.setPriceSingle(2222);
        availability.setPriceDouble(4444);
        calendar.setTimeInMillis(0);
        calendar.set(2019, 3, 28);
        Date date1 = calendar.getTime();
        availability.setToDate(date1);
        calendar.setTimeInMillis(0);
        calendar.set(2019, 3, 28);
        Date date2 = calendar.getTime();
        availability.setFromDate(date2);

        System.out.println(availabilities.toString());
        List<Availability> availabilities1 = availabilityController.getAllAvailability();
        int expected = availabilities.size();
        Assert.assertEquals(expected, actual + 1);

    }

    @Test
    @Rollback
    public void testUpdate() {
        Availability availabilityFromDB = availabilityController.getAvailabilityById(1);
        availabilityFromDB.setPriceDouble(555);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019, 02, 28);
        Date date = calendar.getTime();
        availabilityFromDB.setFromDate(date);
        calendar.setTimeInMillis(0);
        calendar.set(2019, 3, 28);
        Date date1 = calendar.getTime();
        availabilityFromDB.setToDate(date1);
        availabilityFromDB.setRoomType(RoomType.DOUBLE);
        availabilityFromDB.setPriceSingle(222);
        availabilityFromDB.setRoomName("sdsdushfshfhd");
        availabilityFromDB.setProperty(propertyController.getPropertyById(2));

        System.out.println(availabilityController.toString());

        Availability expected = availabilityController.updateAvailability(availabilityFromDB);
        Availability actual = availabilityFromDB;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback
    public void testDelete() {
        Availability availability = availabilityController.getAvailabilityById(2);
        availabilityController.deleteAvailability(2);

        Assert.assertNotNull(availability);
    }

    @Test
    @Rollback(false)
    @Transactional
    public void testFindAvailabilitiesByFromDateLessThanEqualAndToDateGreaterThanEqual() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(0);
        calendar1.set(2019, Calendar.AUGUST, 22);
        Date fromDate = calendar1.getTime();

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(0);
        calendar2.set(2019, Calendar.AUGUST, 23);
        Date toDate = calendar2.getTime();

        List<Availability> allAvailability;
        allAvailability = availabilityController.findAvailabilitiesByFromDateLessThanEqualAndToDateGreaterThanEqual(fromDate, toDate);

        System.out.println(allAvailability.toString());
        Assert.assertEquals(1, allAvailability.size());
    }

    @Test
    @Rollback(false)
    @Transactional
    public void testAllAvailabilityFromAndToDate() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(0);
        calendar1.set(2019, Calendar.AUGUST, 22);
        Date fromDate = calendar1.getTime();

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(0);
        calendar2.set(2019, Calendar.AUGUST, 23);
        Date toDate = calendar2.getTime();

        availabilityController.allAvailabilityFromAndToDate(fromDate, toDate);
    }

}
