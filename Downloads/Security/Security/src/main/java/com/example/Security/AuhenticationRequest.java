package com.example.Security;

public class AuhenticationRequest {


    private String username;
    private String password;

    public AuhenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuhenticationRequest() {
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
}
