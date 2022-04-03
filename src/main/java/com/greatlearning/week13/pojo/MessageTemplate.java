package com.greatlearning.week13.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageTemplate {


    @JsonProperty("role")
    private String role;
    @JsonProperty("username")
    private String username;
    @JsonProperty("message")
    private String message;

    public MessageTemplate() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageTemplate(String role, String username, String message) {
        this.role = role;
        this.username = username;
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageTemplate{" +
                "role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
