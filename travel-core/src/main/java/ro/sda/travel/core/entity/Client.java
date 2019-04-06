package ro.sda.travel.core.entity;

import ro.sda.travel.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "client", schema = "travel")
public class Client extends BaseEntity {


    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "mail", length = 40, nullable = false)
    private String email;

    @Column(name = "phone", length = 15)
    private String telephone;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return name.equals(client.name) &&
                email.equals(client.email) &&
                telephone.equals(client.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, telephone);
    }
}
