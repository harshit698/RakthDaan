package com.example.dellpc.bloodbank;

public class Chat_data {
    private String message,user_name;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public Chat_data() {
    }
    public Chat_data(String message, String user_name) {
        this.message = message;
        this.user_name = user_name;
    }
}  