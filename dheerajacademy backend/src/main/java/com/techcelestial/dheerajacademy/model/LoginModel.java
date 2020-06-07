package com.techcelestial.dheerajacademy.model;

import javax.persistence.*;

@Entity
@Table(name = "LoginMaster")

public class LoginModel {
    @Id
    @GeneratedValue
    @Column(name = "login_id")
    private Integer loginId;

    @Column(name = "name")
    private String name;

    @Column(name = "login_username")
    private String username;

    @Column(name = "login_password")
    private String password;

    @Column(name = "login_repeatPassword")
    private String repeatPassword;

    @Column(name = "status")
    private String status;


    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
