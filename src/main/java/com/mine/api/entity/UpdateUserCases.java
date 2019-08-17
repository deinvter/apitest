package com.mine.api.entity;

public class UpdateUserCases {
    private Long id;

    private Long userId;

    private String name;

    private String password;

    private Boolean expried;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Boolean getExpried() {
        return expried;
    }

    public void setExpried(Boolean expried) {
        this.expried = expried;
    }
}