package com.acme.domain;

import javax.persistence.*;

@Entity
public class Address implements java.io.Serializable {
    @Id
    private
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    long id = 0;
    @Version
    private
    @Column(name = "version")
    int version = 0;

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    @Column
    private String street;

    public String getStreet() {
        return this.street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    @Column
    private String zip;

    public String getZip() {
        return this.zip;
    }

    public void setZip(final String zip) {
        this.zip = zip;
    }

    @Column
    private String city;

    public String getCity() {
        return this.city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "[" + id + ", " + version + ", " + street + ", " + zip + ", " + city + "]";
    }
}
