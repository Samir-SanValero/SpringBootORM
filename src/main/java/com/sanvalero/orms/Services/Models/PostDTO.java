package com.sanvalero.orms.Services.Models;

import com.sanvalero.orms.Repositories.Entities.UserEntity;

public class PostDTO {
    public String title;
    public String description;
    public Long id;
    public Long userId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

}
