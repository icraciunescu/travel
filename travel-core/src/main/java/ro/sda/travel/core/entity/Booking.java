package ro.sda.travel.core.entity;

import ro.sda.travel.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "booking", schema = "travel")
public class Booking extends BaseEntity {

    @Column(name = "client_id", length = 40, nullable = false)
    private int clientId;

    @Column(name = "property_id", length = 11, nullable = false)
    private int propertyId;

    @Column(name = "check_in", length = 2, nullable = false)
    private int checkIn;

    @Column(name = "check_out", length = 2, nullable = false)
    private int checkOut;

    @Column(name = "nr_of_person", length = 2, nullable = false)
    private int nrOfPersons;

    @Column(name = "room_type", length = 40, nullable = false)
    private String roomType;

    @Column(name = "number_of_rooms", length = 3, nullable = false)
    private int numberOfRooms;

    @Column(name = "booking_data", length = 2, nullable = false)
    private int bookingData;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(int checkIn) {
        this.checkIn = checkIn;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }

    public int getNrOfPersons() {
        return nrOfPersons;
    }

    public void setNrOfPersons(int nrOfPersons) {
        this.nrOfPersons = nrOfPersons;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getBookingData() {
        return bookingData;
    }

    public void setBookingData(int bookingData) {
        this.bookingData = bookingData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return clientId == booking.clientId &&
                propertyId == booking.propertyId &&
                checkIn == booking.checkIn &&
                checkOut == booking.checkOut &&
                nrOfPersons == booking.nrOfPersons &&
                numberOfRooms == booking.numberOfRooms &&
                bookingData == booking.bookingData &&
                roomType.equals(booking.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, propertyId, checkIn, checkOut, nrOfPersons, roomType, numberOfRooms, bookingData);
    }
}
