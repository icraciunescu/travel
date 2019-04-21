package ro.sda.travel.core.entity;

import ro.sda.travel.core.base.BaseEntity;
import ro.sda.travel.core.enums.RoomType;

import javax.persistence.*;
import java.util.Date;
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
    @ManyToOne
    @JoinColumn(name = "availability_id")
    private Availability availability;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_in", nullable = false)
    private Date checkIn;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_out", nullable = false)
    private Date checkOut;

    @Column(name = "nr_of_person", length = 2, nullable = false)
    private int nrOfPersons;

    @Column(name = "room_type", length = 40, nullable = false)
    private RoomType roomType;

    @Column(name = "number_of_rooms", length = 3, nullable = false)
    private int numberOfRooms;

    @Temporal(TemporalType.DATE)
    @Column(name = "booking_data", nullable = false)
    private Date bookingData;

    public Client getClient() {
        return client;
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

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getNrOfPersons() {
        return nrOfPersons;
    }

    public void setNrOfPersons(int nrOfPersons) {
        this.nrOfPersons = nrOfPersons;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Date getBookingData() {
        return bookingData;
    }

    public void setBookingData(Date bookingData) {
        this.bookingData = bookingData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return nrOfPersons == booking.nrOfPersons &&
                numberOfRooms == booking.numberOfRooms &&
                Objects.equals(client, booking.client) &&
                Objects.equals(property, booking.property) &&
                Objects.equals(availability, booking.availability) &&
                Objects.equals(checkIn, booking.checkIn) &&
                Objects.equals(checkOut, booking.checkOut) &&
                roomType == booking.roomType &&
                Objects.equals(bookingData, booking.bookingData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, property, availability, checkIn, checkOut, nrOfPersons, roomType, numberOfRooms, bookingData);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "client=" + client +
                ", property=" + property +
                ", availability=" + availability +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", nrOfPersons=" + nrOfPersons +
                ", roomType=" + roomType +
                ", numberOfRooms=" + numberOfRooms +
                ", bookingData=" + bookingData +
                '}';
    }

}