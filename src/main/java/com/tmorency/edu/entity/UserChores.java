package com.tmorency.edu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tim on 10/11/2016.
 */
@Entity
@Table(name = "user_chores")
public class UserChores {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    @Column(name = "chore_id")
    private int chore_id;
    @Column(name = "roommate_id")
    private int roommate_id;
    @Column(name = "due_date")
    private Date due_date;
    @Column(name = "completed")
    private boolean completed;

    public UserChores() {
    }

    public UserChores(int chore_id, int roommate_id, Date due_date, boolean completed) {
        this.chore_id = chore_id;
        this.roommate_id = roommate_id;
        this.due_date = due_date;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChore_id() {
        return chore_id;
    }

    public void setChore_id(int chore_id) {
        this.chore_id = chore_id;
    }

    public int getRoommate_id() {
        return roommate_id;
    }

    public void setRoommate_id(int rommate_id) {
        this.roommate_id = rommate_id;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "UserChores{" +
                "id=" + id +
                ", chore_id=" + chore_id +
                ", roommate_id=" + roommate_id +
                ", due_date=" + due_date +
                ", completed=" + completed +
                '}';
    }
}
