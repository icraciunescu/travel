package ro.sda.travel.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.travel.core.entity.Payment;
import ro.sda.travel.core.repository.PaymentRepository;

import java.util.List;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(int id) {
        return paymentRepository.findOne(id);
    }

    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    public Payment updatePayment(Payment payment) {
        Payment paymentFromDb = paymentRepository.findOne(payment.getId());
        return paymentRepository.save(paymentFromDb);
    }

    public void deletePayment(int id) {
        paymentRepository.delete(id);
    }


}
