package ro.sda.travel.core.entity;

import ro.sda.travel.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "properties", schema = "travel")
public class Property extends BaseEntity {


    @Column(name = "name", length = 40, nullable = false)
    private String name;
@ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    private Host host;

    @Column(name = "mail", length = 40,nullable = false)
    private String mail;

    @Column(name = "telephone", length = 20)
    private String telephone;

    @Column(name = "adress", length = 40)
    private String adress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return name.equals(property.name) &&
                host.equals(property.host) &&
                mail.equals(property.mail) &&
                telephone.equals(property.telephone) &&
                adress.equals(property.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, host, mail, telephone, adress);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
