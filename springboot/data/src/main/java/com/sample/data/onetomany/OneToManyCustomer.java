package com.sample.data.onetomany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class OneToManyCustomer {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToMany(cascade =  CascadeType.ALL)
    private List<OneToManyAddress> address = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OneToManyAddress> getAddress() {
        return address;
    }

    public void setAddress(List<OneToManyAddress> address) {
        this.address = address;
    }

}
