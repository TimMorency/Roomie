package com.tmorency.edu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tim on 9/27/2016.
 */
@Entity
@Table(name = "rental")
public class Rental {


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "lease_start")
    private Date lease_start;

    @Column(name = "lease_end")
    private Date lease_end;

    @Column(name = "rent")
    private int rent;

    public Rental() {
    }

    public Rental(String address, String city, String state,
                  String zip, Date lease_start, Date lease_end, int rent) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.lease_start = lease_start;
        this.lease_end = lease_end;
        this.rent = rent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Date getLease_start() {
        return lease_start;
    }

    public void setLease_start(Date lease_start) {
        this.lease_start = lease_start;
    }

    public Date getLease_end() {
        return lease_end;
    }

    public void setLease_end(Date lease_end) {
        this.lease_end = lease_end;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "Rental{id='" + id + "', address='" + address + "', " +
                "city='" + city + "', state='" + state + "', zip='" + zip
                + "', lease_start='" + lease_start.toLocaleString() + "', "
                + "lease_end='" + lease_end.toLocaleString() + "', "
                + "rent='" + rent + "'}";
    }
}
