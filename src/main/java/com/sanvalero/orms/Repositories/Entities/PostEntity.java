package com.sanvalero.orms.Repositories.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Posts")
@Entity(name = "Posts")
public class PostEntity {

    private @Id @GeneratedValue Long id;
    private String title;
    private String description;
    private Long userId;

    public PostEntity() {}

    public PostEntity(String title, String description, Long userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
