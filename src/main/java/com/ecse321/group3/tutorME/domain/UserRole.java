package com.ecse321.group3.tutorME.domain;

import javax.persistence.*;

@Entity
public abstract class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @OneToOne(mappedBy = "userRole", cascade = CascadeType.MERGE)
    private UserEntity user;

    public UserRole() {
    }

    public UserRole(int userId, UserEntity user) {
        this.userId = userId;
        this.user = user;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
