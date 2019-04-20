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

    @Temporal(TemporalType.DATE)
    @Column(name = "from_date", nullable = false)
    public Date fromDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "to_date", nullable = false)
    public Date toDate;

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
                property.equals(that.property) &&
                roomName.equals(that.roomName) &&
                fromDate.equals(that.fromDate) &&
                toDate.equals(that.toDate) &&
                roomType.equals(that.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property, roomName, fromDate, toDate, roomType, priceDouble, priceSingle);
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

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromData) {
        this.fromDate = fromData;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toData) {
        this.toDate = toData;
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

    @Override
    public String toString() {
        return "Availability{" +
                "property=" + property +
                ", roomName='" + roomName + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", roomType='" + roomType + '\'' +
                ", priceDouble=" + priceDouble +
                ", priceSingle=" + priceSingle +
                '}';
    }
}
