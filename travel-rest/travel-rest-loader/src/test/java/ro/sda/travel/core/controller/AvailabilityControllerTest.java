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
import ro.sda.travel.core.entity.Host;
import ro.sda.travel.core.entity.Property;
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
    public void testCreate() {

        Host host = new Host();
        host.setName("name");
        host.setEmail("mail");
        hostController.createHost(host);

        Property property = new Property();
        property.setName("name");
        property.setHost(host);
        property.setMail("pr@pr.com");
        propertyController.createProperty(property);

        Availability availability = new Availability();
        availability.setProperty(property);
        availability.setPriceDouble(1);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);

        calendar.set(2019, 07, 21);
        Date fromData = calendar.getTime();
        availability.setFromDate(fromData);

        availability.setPriceSingle(1);
        availability.setRoomName("name");
        availability.setRoomType(RoomType.SINGLE);

        calendar.set(2019, 07, 28);
        Date toData = calendar.getTime();
        availability.setToDate(toData);

        availabilityController.createAvailability(availability);
        System.out.println(availability.toString());
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
        availability.setRoomType(RoomType.SINGLE);
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
}
