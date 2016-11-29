package com.tmorency.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Tim on 11/25/2016.
 */
@Entity
@Table(name = "user_roles")
public class UserRoles {
    @Id
    @Column(name = "user_name")
    public String userName;
    @Column(name = "role_name")
    public String roleName;

    public UserRoles() {
    }

    public UserRoles(String userName, String roleName) {
        this.userName = userName;
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
