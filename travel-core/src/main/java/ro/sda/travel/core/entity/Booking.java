package ro.sda.travel.core.entity;

import ro.sda.travel.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "booking", schema = "travel")
public class Booking extends BaseEntity {
@ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

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

    public Client getClient() {
        return client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return checkIn == booking.checkIn &&
                checkOut == booking.checkOut &&
                nrOfPersons == booking.nrOfPersons &&
                numberOfRooms == booking.numberOfRooms &&
                bookingData == booking.bookingData &&
                client.equals(booking.client) &&
                property.equals(booking.property) &&
                roomType.equals(booking.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, property, checkIn, checkOut, nrOfPersons, roomType, numberOfRooms, bookingData);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
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
}