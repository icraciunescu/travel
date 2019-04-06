package ro.sda.travel.core.entity;

import ro.sda.travel.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "payments", schema = "travel")
public class Payment extends BaseEntity {


    @Column(name = "amount", length = 11, nullable = false)
    private int amount;

    @Column(name = "payment_data", length = 2, nullable = false)
    private int paymentData;

    @Column(name = "booking_id", length = 11, nullable = false)
    private int bookingId;


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(int paymentData) {
        this.paymentData = paymentData;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return amount == payment.amount &&
                paymentData == payment.paymentData &&
                bookingId == payment.bookingId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, paymentData, bookingId);
    }
}
