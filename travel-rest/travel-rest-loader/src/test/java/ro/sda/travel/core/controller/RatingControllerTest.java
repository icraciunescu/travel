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
import ro.sda.travel.core.entity.Rating;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class RatingControllerTest {

    @Autowired
    @Qualifier("ratingController")
    public RatingController ratingController;

    @Autowired
    @Qualifier("clientController")
    public ClientController clientController;

    @Autowired
    @Qualifier("propertyController")
    public PropertyController propertyController;


    @Test
    @Rollback(false)
    public void testCreate() {
        Rating rating = new Rating();
        rating.setClient(clientController.getClientById(15));
        rating.setComment("commentTest");
        rating.setProperty(propertyController.getPropertyById(3));

        ratingController.createRating(rating);
        System.out.println(rating.toString());
        Assert.assertNotNull(rating);
    }

    @Test
    @Rollback(false)
    public void testRead() {
        Rating rating = ratingController.getRatingById(4);
        int actual = rating.getId();
        int expected = 4;
        Assert.assertEquals(expected,actual);
    }

}
