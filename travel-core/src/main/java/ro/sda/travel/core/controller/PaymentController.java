package ro.sda.travel.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.travel.core.entity.Payment;
import ro.sda.travel.core.service.PaymentService;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    public Payment createPayment(Payment payment) {
        return paymentService.createPayment(payment);
    }
}
