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

    @Test
    @Rollback(false)
    public void testRead(){
        Client client = clientController.getClientById(1);
        int actual = client.getId();
        int expected = 1;
        System.out.println(client.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testUpdate() {
        Client clientFromDb = clientController.getClientById(2);
        clientFromDb.setName("vasile");
        clientFromDb.setEmail("old@mail.com");
        clientFromDb.setTelephone("123456789");
        Client client = clientController.updateClient(2,"nicu","mail@mail.com","0000000");
        Client expected = clientController.updateClient(2,"ion","mail@mail.com","0000000");
        Client actual = client;
        Assert.assertEquals(expected, actual);

    }

    @Test
    @Rollback(false)
    public void testDelete(){
        Client client = clientController.getClientById(2);
        clientController.deleteClient(2);
        Assert.assertNotNull(client);
    }

}
