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
import ro.sda.travel.core.entity.Payment;

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class PaymentControllerTest {

    @Autowired
    @Qualifier("paymentController")
    public PaymentController paymentController;

    @Autowired
    @Qualifier("bookingController")
    public BookingController bookingController;

    @Test
    @Rollback(false)
    public void testCreate() {
        Payment payment = new Payment();
        payment.setAmount(100);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019,04,14);
        Date date = calendar.getTime();
        payment.setPaymentData(date);
        payment.setBooking(bookingController.getBookingById(1));

        paymentController.createPayment(payment);
        System.out.println(payment.toString());
        Assert.assertNotNull(payment);

    }

    @Test
    @Rollback(false)
    public void testRead() {
        Payment payment = paymentController.getPaymentById(1);
        int actual = payment.getId();
        int expected = 1;
        Assert.assertEquals(expected,actual);
    }
}
