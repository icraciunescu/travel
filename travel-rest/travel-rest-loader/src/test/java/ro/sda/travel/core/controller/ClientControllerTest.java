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
import ro.sda.travel.core.entity.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ClientControllerTest {

    @Autowired
    @Qualifier("clientController")
    public ClientController clientController;

    @Test
    @Rollback(false)
    public void testCreate() {
        Client client = new Client();
        client.setName("Vasile");
        clientController.createClient(client);
        Assert.assertNotNull(client);
    }


}
