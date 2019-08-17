package com.mine.api.entity;

public class AddUserCases {
    private Long id;

    private String name;

    private String password;

    private int expried;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public int getExpried() {
        return expried;
    }

    public void setExpried(int expried) {
        this.expried = expried;
    }
}