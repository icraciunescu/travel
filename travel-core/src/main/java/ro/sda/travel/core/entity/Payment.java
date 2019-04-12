package ro.sda.travel.core.entity;

import ro.sda.travel.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "payments", schema = "travel")
public class Payment extends BaseEntity {


    @Column(name = "amount", length = 11, nullable = false)
    private int amount;

    @Column(name = "payment_data", nullable = false)
    private Date paymentData;
@OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return amount == payment.amount &&
                paymentData == payment.paymentData &&
                booking.equals(payment.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, paymentData, booking);
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(Date paymentData) {
        this.paymentData = paymentData;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
