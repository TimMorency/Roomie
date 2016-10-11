package com.tmorency.edu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Tim on 9/13/2016.
 */
@Entity
@Table(name = "roommate")
public class RoomMate {



    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;


    @Column(name = "rental_id")
    private int rentalId;

    @Column(name = "user_name_fk")
    private String user_name_fk;

    public RoomMate() {

    }

    public RoomMate(String firstName, String lastName, String email, String phoneNumber, int rentalId, String user_name_fk) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.rentalId = rentalId;
        this.user_name_fk = user_name_fk;
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


    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }


    public String getUser_name_fk() {
        return user_name_fk;
    }

    public void setUser_name_fk(String user_name_fk) {
        this.user_name_fk = user_name_fk;
    }

    @Override
    public String toString() {
        return "RoomMate{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", rentalId=" + rentalId +
                ", user_name_fk=" + user_name_fk +
                '}';
    }
}
