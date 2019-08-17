package com.mine.api.entity;

public class UserListCases {
    private Long id;

    private Long userId;

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

    public Boolean getExpried() {
        return expried;
    }

    public void setExpried(Boolean expried) {
        this.expried = expried;
    }
}