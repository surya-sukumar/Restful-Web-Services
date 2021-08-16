package com.example.Springbootservices.restfulwebservices.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Valid
@Entity
public class User {

    @Id
    private int id;
    @Size(min = 2)
    private String name;
    @Size(min = 2)
    private String tech;

    //For JPA related queries this constructor is mandatory
    public User() {
    }

    public User(int id, String name, String tech) {
        this.id = id;
        this.name = name;
        this.tech = tech;
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

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
