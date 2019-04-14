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
import ro.sda.travel.core.entity.Host;
import ro.sda.travel.core.enums.RoomType;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class HostControllerTest {

    @Autowired
    @Qualifier("hostController")
    public HostController hostController;

    @Test
    @Rollback(false)
    public void testCreate() {
        Host host = new Host();
        host.setName("testHost");
        host.setEmail("host@host.com");
        hostController.createHost(host);
        System.out.println(host.toString());
        Assert.assertNotNull(host);
    }

    @Test
    @Rollback(false)
    public void testRead() {
        Host host = hostController.getHostById(3);
        int actual = host.getId();
        int expected = 3;
        Assert.assertEquals(expected,actual);
    }
    @Test
    @Rollback(false)
    public void testReadAll() {
        List<Host> hosts = hostController.getAllHost();
        int actual = hosts.size();
        Host host =new Host();
        host.setEmail("dknskdskdj@gmail.ro");
        host.setName("trtartara");

        System.out.println(host.toString());
        List<Host> hosts1 = hostController.getAllHost();
        int expected = hosts.size();
        Assert.assertEquals(expected, actual + 1);

    }

    @Test
    @Rollback
    public void testUpdate() {
        Host hostFromDb=hostController.getHostById(1);
        hostFromDb.setName("oaksdod");
        hostFromDb.setEmail("fsffsfsfdf");
        System.out.println(hostController.toString());

        Host expected = hostController.updateHost(hostFromDb);
        Host actual = hostFromDb;
        Assert.assertEquals(expected, actual);
    }
    @Test
    @Rollback
    public void testDelete(){
        Host host= hostController.getHostById(1);
        hostController.deleteHost(1);
        Assert.assertNotNull(host);
    }
}
