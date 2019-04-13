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

import java.util.List;

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
        client.setName("vasile");
        client.setEmail("old@mail.com");
        client.setTelephone("123456789");
        clientController.createClient(client);
        System.out.println(client.toString());
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
    public void testReadAll(){
        List<Client> clients = clientController.getAllClient();

        int actual = clients.size();

        Client client = new Client();
        client.setName("test");
        client.setEmail("test@mail.com");
        client.setTelephone("123400000");
        clientController.createClient(client);

        System.out.println(clients.toString());

        List<Client> clients2 = clientController.getAllClient();

        int expected = clients2.size();

        Assert.assertEquals(expected, actual + 1);
    }

    @Test
    @Rollback(false)
    public void testUpdate() {
        Client clientFromDb = clientController.getClientById(1);
        clientFromDb.setName("vasile");
        clientFromDb.setEmail("old@mail.com");
        clientFromDb.setTelephone("123456789");
        Client client = clientController.updateClient(1,"nicu","mail@mail.com","000000000");
        Client expected = clientController.updateClient(1,"ion","mail@mail.com","000000000");
        Client actual = client;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testDelete(){
        Client client = clientController.getClientById(16);
        clientController.deleteClient(16);
        Assert.assertNotNull(client);
    }

}
