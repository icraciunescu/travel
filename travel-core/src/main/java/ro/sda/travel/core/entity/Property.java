package ro.sda.travel.core.entity;

import ro.sda.travel.core.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "properties", schema = "travel")
public class Property extends BaseEntity {

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "host_id", length = 40, nullable = false)
    private String hostId;

    @Column(name = "mail", length = 40,nullable = false)
    private String mail;

    @Column(name = "telephone", length = 20)
    private String telephone;

    @Column(name = "adress", length = 40)
    private String adress;


}
