package com.techcelestial.dheerajacademy.dto;

public class ForgotDto {
    private Integer forgotId;
    private String forgotUsername;
    private String forgotPassword;
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
