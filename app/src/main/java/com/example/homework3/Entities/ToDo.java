package com.example.homework3.Entities;

public class ToDo {

    private int userId;
    private int id;
    private String title;

    public ToDo() {
        userId = 0;
        id = 0;
        title = null;
    }

    public ToDo(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
