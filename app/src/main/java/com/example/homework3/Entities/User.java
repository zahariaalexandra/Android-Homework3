package com.example.homework3.Entities;

public class User {

    int id;
    private String name;

    public User() {
        this.name = null;
        this.id = 0;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
