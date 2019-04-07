package ro.sda.travel.core.entity;

import ro.sda.travel.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rating", schema = "travel")
public class Rating extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "comment", length = 400)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return property.equals(rating.property) &&
                comment.equals(rating.comment) &&
                property.equals(rating.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property, comment, property);
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
