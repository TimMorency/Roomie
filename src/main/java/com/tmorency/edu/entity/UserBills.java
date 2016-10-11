package com.tmorency.edu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tim on 10/11/2016.
 */
@Entity
@Table(name = "user_bills")
public class UserBills {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "roommate_id")
    private int roommate_id;

    @Column(name = "bill_id")
    private int bill_id;

    @Column(name = "split_amt")
    private int split_amt;

    @Column(name = "pay_by")
    private Date pay_by;


    public UserBills() {

    }

    public UserBills(int id, int roommate_id, int bill_id, int split_amt, Date pay_by) {
        this.id = id;
        this.roommate_id = roommate_id;
        this.bill_id = bill_id;
        this.split_amt = split_amt;
        this.pay_by = pay_by;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoommate_id() {
        return roommate_id;
    }

    public void setRoommate_id(int roommate_id) {
        this.roommate_id = roommate_id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getSplit_amt() {
        return split_amt;
    }

    public void setSplit_amt(int split_amt) {
        this.split_amt = split_amt;
    }

    public Date getPay_by() {
        return pay_by;
    }

    public void setPay_by(Date pay_by) {
        this.pay_by = pay_by;
    }

    @Override
    public String toString() {
        return "UserBills{" +
                "id=" + id +
                ", roommate_id=" + roommate_id +
                ", bill_id=" + bill_id +
                ", split_amt=" + split_amt +
                ", pay_by=" + pay_by +
                '}';
    }
}
