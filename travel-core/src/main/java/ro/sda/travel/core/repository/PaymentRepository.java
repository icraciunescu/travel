package ro.sda.travel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.travel.core.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
