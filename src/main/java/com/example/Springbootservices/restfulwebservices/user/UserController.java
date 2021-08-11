package com.example.Springbootservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> users(){
        return userDaoService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable int id){
        return userDaoService.findOne(id);
    }

    @PostMapping("/users/create")
    public void createUser(@RequestBody User user){
        userDaoService.save(user);
    }


}
