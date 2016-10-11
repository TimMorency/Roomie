package com.tmorency.edu.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tim on 10/11/2016.
 */
@Entity
@Table(name = "chores")
public class Chores {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    @Column(name = "chore_name")
    private String chore_name;
    @Column(name = "chore_description")
    private String chore_description;
    @Column(name = "rental_id")
    private int rental_id;

    public Chores() {
    }

    public Chores(int id, String chore_name, String chore_description, int rental_id) {
        this.id = id;
        this.chore_name = chore_name;
        this.chore_description = chore_description;
        this.rental_id = rental_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChore_name() {
        return chore_name;
    }

    public void setChore_name(String chore_name) {
        this.chore_name = chore_name;
    }

    public String getChore_description() {
        return chore_description;
    }

    public void setChore_description(String chore_description) {
        this.chore_description = chore_description;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    @Override
    public String toString() {
        return "Chores{" +
                "id=" + id +
                ", chore_name='" + chore_name + '\'' +
                ", chore_description='" + chore_description + '\'' +
                ", rental_id=" + rental_id +
                '}';
    }
}
