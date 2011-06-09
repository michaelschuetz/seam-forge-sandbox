package com.acme.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer implements java.io.Serializable {
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
    private String firstName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    @Column
    private String lastName;

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "[" + id + ", " + version + ", " + firstName + ", " + lastName + "]";
    }

    @OneToMany
    private Set<Address> addresses = new HashSet<Address>();

    public Set<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(final Set<Address> addresses) {
        this.addresses = addresses;
    }
}
