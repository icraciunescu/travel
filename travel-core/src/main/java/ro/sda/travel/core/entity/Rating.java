package ro.sda.travel.core.entity;

import ro.sda.travel.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "rating", schema = "travel")
public class Rating extends BaseEntity {

    @Column(name = "client_id", length = 11, nullable = false)
    private int clientId;

    @Column(name = "comment", length = 400)
    private String comment;

    @Column(name = "property_id", length = 11, nullable = false)
    private int propertyId;

    @Column(name = "rating", length = 1)
    private int rating;


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return clientId == rating1.clientId &&
                propertyId == rating1.propertyId &&
                rating == rating1.rating &&
                comment.equals(rating1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, comment, propertyId, rating);
    }
}
