package com.example.security.model;

public class StudentModel {
    private int id;
    private String name;
    private String std;

    public StudentModel(int id, String name, String std) {
        this.id = id;
        this.name = name;
        this.std = std;
    }

    public StudentModel() {
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

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }
}
