package com.sample.data.onetomany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OneToManyAddress {

    // Coming from the other end of the relationship, we have a Customer that has a list of Address
    // and the Address don't know about the Customers they are associated with.

    // The Easiest variant is also the cleanest and most maintainable Address has a Customer
    // field Annotated with @ManyToOne. A Customer on the other hand doesn't know anything about his Address
    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String street;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
