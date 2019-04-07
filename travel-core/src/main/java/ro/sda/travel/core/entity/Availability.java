package ro.sda.travel.core.entity;

import ro.sda.travel.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "availability", schema = "travel")
public class Availability extends BaseEntity {

@ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    public Property property;

    @Column(name = "room_name", length = 40, nullable = false)
    public String roomName;

    @Column(name = "from_data", length = 2, nullable = false)
    public int fromData;

    @Column(name = "to_data", length = 2, nullable = false)
    public int toData;

    @Column(name = "room_type", length = 40, nullable = false)
    public String roomType;

    @Column(name = "price_double", length = 11, nullable = false)
    public int priceDouble;

    @Column(name = "price_single", length = 11, nullable = false)
    public int priceSingle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Availability that = (Availability) o;
        return fromData == that.fromData &&
                toData == that.toData &&
                priceDouble == that.priceDouble &&
                priceSingle == that.priceSingle &&
                property.equals(that.property) &&
                roomName.equals(that.roomName) &&
                roomType.equals(that.roomType);
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

    public int getFromData() {
        return fromData;
    }

    public void setFromData(int fromData) {
        this.fromData = fromData;
    }

    public int getToData() {
        return toData;
    }

    public void setToData(int toData) {
        this.toData = toData;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
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
