package ro.sda.travel.core.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.travel.core.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
