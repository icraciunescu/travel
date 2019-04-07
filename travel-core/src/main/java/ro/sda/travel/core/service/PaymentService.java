package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.controller.PaymentController;
import ro.sda.travel.core.entity.Payment;


@Service
public class PaymentService {

    @Autowired
    private PaymentController paymentController;

    public Payment createPayment(Payment payment) {
        return paymentController.createPayment(payment);
    }
}
