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
import ro.sda.travel.core.entity.Property;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class PropertyControllerTest {

    @Autowired
    @Qualifier("propertyController")
    public PropertyController propertyController;

    @Autowired
    @Qualifier("hostController")
    public HostController hostController;


    @Test
    @Rollback(false)
    public void testCreate() {
        Property property = new Property();
        property.setName("testProperty");
        property.setHost(hostController.getHostById(3));
        property.setMail("property@property.com");
        property.setTelephone("123450000");
        property.setAdress("adressProperty");

        propertyController.createProperty(property);
        System.out.println(property.toString());
        Assert.assertNotNull(property);
    }

    @Test
    @Rollback(false)
    public void testRead() {
        Property property = propertyController.getPropertyById(3);
        int actual = property.getId();
        int expected = 3;
        Assert.assertEquals(expected,actual);
    }

}
