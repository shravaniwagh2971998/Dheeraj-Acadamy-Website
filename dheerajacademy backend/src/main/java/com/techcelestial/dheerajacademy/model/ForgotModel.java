package com.techcelestial.dheerajacademy.model;

import javax.persistence.*;

@Entity
@Table(name = "ForgotMaster")
public class ForgotModel {
    @Id
    @GeneratedValue
    @Column(name = "forgot_id")
    private Integer forgotId;

    @Column(name = "forgot_username")
    private String forgotUsername;

    @Column(name = "forgot_password")
    private String forgotPassword;

    @Column(name = "forgot_confirm_password")
    private String forgotConpassword;

    public Integer getForgotId() {
        return forgotId;
    }

    public void setForgotId(Integer forgotId) {
        this.forgotId = forgotId;
    }

    public String getForgotUsername() {
        return forgotUsername;
    }

    public void setForgotUsername(String forgotUsername) {
        this.forgotUsername = forgotUsername;
    }

    public String getForgotPassword() {
        return forgotPassword;
    }

    public void setForgotPassword(String forgotPassword) {
        this.forgotPassword = forgotPassword;
    }

    public String getForgotConpassword() {
        return forgotConpassword;
    }

    public void setForgotConpassword(String forgotConpassword) {
        this.forgotConpassword = forgotConpassword;
    }
}
