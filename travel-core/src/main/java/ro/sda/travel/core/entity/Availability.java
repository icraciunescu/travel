package ro.sda.travel.core.entity;

import ro.sda.travel.core.base.BaseEntity;
import ro.sda.travel.core.enums.RoomType;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "availability", schema = "travel")
public class Availability extends BaseEntity {

@ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    public Property property;

    @Column(name = "room_name", length = 40, nullable = false)
    public String roomName;

    @Column(name = "from_data", nullable = false)
    public Date fromData;

    @Column(name = "to_data", nullable = false)
    public Date toData;

    @Column(name = "room_type", length = 40, nullable = false)
    public RoomType roomType;

    @Column(name = "price_double", length = 11, nullable = false)
    public int priceDouble;

    @Column(name = "price_single", length = 11, nullable = false)
    public int priceSingle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Availability that = (Availability) o;
        return priceDouble == that.priceDouble &&
                priceSingle == that.priceSingle &&
                Objects.equals(property, that.property) &&
                Objects.equals(roomName, that.roomName) &&
                Objects.equals(fromData, that.fromData) &&
                Objects.equals(toData, that.toData) &&
                roomType == that.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(property, roomName, fromData, toData, roomType, priceDouble, priceSingle);
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Date getFromData() {
        return fromData;
    }

    public void setFromData(Date fromData) {
        this.fromData = fromData;
    }

    public Date getToData() {
        return toData;
    }

    public void setToData(Date toData) {
        this.toData = toData;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getPriceDouble() {
        return priceDouble;
    }

    public void setPriceDouble(int priceDouble) {
        this.priceDouble = priceDouble;
    }

    public int getPriceSingle() {
        return priceSingle;
    }

    public void setPriceSingle(int priceSingle) {
        this.priceSingle = priceSingle;
    }
}
