package ro.sda.travel.core.entity;

import ro.sda.travel.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "hosts", schema = "travel")
public class Host extends BaseEntity {

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "mail", length = 40, nullable = false)
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Host host = (Host) o;
        return name.equals(host.name) &&
                email.equals(host.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
