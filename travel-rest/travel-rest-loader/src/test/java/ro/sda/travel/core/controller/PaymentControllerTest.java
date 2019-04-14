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
import java.util.List;

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
        calendar.set(2019, 04, 14);
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
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testReadAll() {
        List<Payment> payments = paymentController.getAllPayment();

        int actual = payments.size();

        Payment payment = new Payment();
        payment.setAmount(2);
        payment.setBooking(bookingController.getBookingById(5));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019, 02, 28);
        Date date = calendar.getTime();
        payment.setPaymentData(date);
        paymentController.createPayment(payment);

        System.out.println(payment.toString());
        List<Payment> payments1 = paymentController.getAllPayment();
        int expected = payments.size();
        Assert.assertEquals(expected, actual + 1);
    }

    @Test
    @Rollback(false)
    public void testUpdate() {
        Payment paymentFromDb = paymentController.getPaymentById(15);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(0);
        calendar.set(2019, 02, 28);
        Date date = calendar.getTime();
        paymentFromDb.setPaymentData(date);
        paymentFromDb.setBooking(bookingController.getBookingById(2));
        paymentFromDb.setAmount(20);

        System.out.println(paymentController.toString());

        Payment expected = paymentController.updatePayment(paymentFromDb);
        Payment actual = paymentFromDb;
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testDelete() {
        Payment payment = paymentController.getPaymentById(16);
        paymentController.deletePayment(15);
        Assert.assertNotNull(payment);
    }
}
