//package ro.sda.travel.core.controller;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//import ro.sda.travel.core.entity.Availability;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:/spring-config/spring-root.xml")
//@Transactional
//public class AvailabilityControllerTest {
//
//    @Autowired
//    @Qualifier("availabilityController")
//    public AvailabilityController availabilityController;
//
//    @Test
//    @Rollback(false)
//    public void testCreate() {
//        Availability availability = new Availability();
//
//        availability.setPriceDouble(2);
//        availability.setFromData(1);
//        availabilityController.createAvailability(availability);
//        Assert.assertNotNull(availability);
//    }
//
//}
