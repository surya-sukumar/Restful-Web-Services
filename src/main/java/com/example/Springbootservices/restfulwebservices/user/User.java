package com.example.Springbootservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Valid
@Entity
public class User {

    @Id
    private int id;
    @Size(min = 2)
    private String name;
    @Size(min = 2)
    private String tech;
    @OneToMany(mappedBy = "user")//relationship column of user in post
    @JsonIgnore
    private List<Post> posts;

    //For JPA related queries this constructor is mandatory
    //All persistent classes must have a default constructor
    // so that Hibernate can instantiate them using Constructor.newInstance(). It is recommended
    // that you have a default constructor with at least package visibility for runtime
    // proxy generation in Hibernate. so you must add a default constructor.
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
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
