package com.tmorency.edu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Tim on 9/13/2016.
 */
@Entity
@Table(name = "roommate")
public class roomMate {

    @Column(name = "first_name")
    private String firstName;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    public roomMate() {

    }

    public roomMate(String firstName, String lastName, int id,
                    String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "RoomMate{firstName='" + firstName + "'," +
                "lastName='" + lastName + "'," +
                "email='" + email + "'," +
                "phone='" + phoneNumber + "'," +
                "id='" + id + "'}";
    }
}
