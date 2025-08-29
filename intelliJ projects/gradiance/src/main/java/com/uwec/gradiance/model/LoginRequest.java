package com.uwec.gradiance.model;
import jakarta.validation.constraints.*;
public class LoginRequest {
    @NotEmpty(message="You must enter your email")
    @Size(min=1, max=100)
    private String email;

    @NotEmpty(message="You must enter your password.")
    @Size(min=1, max=100)
    private String password;


    //getters & setters
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

}
