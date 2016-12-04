package com.tmorency.edu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tim on 10/11/2016.
 */
@Entity
@Table(name = "bills")
public class Bills {


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    @Column(name = "bill_name")
    private String bill_name;
    @Column(name = "bill_amt")
    private int bill_amt;
    @Column(name = "due_date")
    private Date due_date;
    @Column(name = "rentalId")
    private int rentalId;

    public Bills() {
    }

    public Bills(String bill_name, int bill_amt, Date due_date, int rentalId) {
        this.bill_name = bill_name;
        this.bill_amt = bill_amt;
        this.due_date = due_date;
        this.rentalId = rentalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBill_name() {
        return bill_name;
    }

    public void setBill_name(String bill_name) {
        this.bill_name = bill_name;
    }

    public int getBill_amt() {
        return bill_amt;
    }

    public void setBill_amt(int bill_amt) {
        this.bill_amt = bill_amt;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    @Override
    public String toString() {
        return "Bills{" +
                "id=" + id +
                ", bill_name='" + bill_name + '\'' +
                ", bill_amt=" + bill_amt +
                ", due_date=" + due_date +
                ", rentalId=" + rentalId +
                '}';
    }
}
