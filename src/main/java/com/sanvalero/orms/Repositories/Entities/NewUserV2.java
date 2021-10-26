package com.sanvalero.orms.Repositories.Entities;

public class NewUserV2 extends NewUser {
    private String lenguage;

    public NewUserV2() { }

    public NewUserV2(String lenguage) {
        this.lenguage = lenguage;
    }

    public NewUserV2(int id, String name, String lenguage) {
        super(id, name);
        this.lenguage = lenguage;
    }

    public String getLenguage() {
        return lenguage;
    }

    public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }
}
