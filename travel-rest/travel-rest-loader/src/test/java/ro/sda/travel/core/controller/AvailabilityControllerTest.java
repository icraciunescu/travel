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
//        availability.setFromData(3);
        availability.setPriceSingle(1);
        availability.setRoomName("name");
        availability.setRoomType(RoomType.SINGLE);
//        availability.setToData(3);

        availabilityController.createAvailability(availability);
        Assert.assertNotNull(availability);
    }

}
