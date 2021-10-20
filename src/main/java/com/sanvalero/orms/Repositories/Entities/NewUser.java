package com.sanvalero.orms.Repositories.Entities;

public class NewUser {
    
    private int id;
    private String name;

    public NewUser() { }
    
    public NewUser(int id, String name) {
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
