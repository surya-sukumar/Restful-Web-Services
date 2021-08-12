package com.example.Springbootservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
        User user = userDaoService.findOne(id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        //return status and the user added
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public User removeUser(@PathVariable int id){

        User user = userDaoService.deleteById(id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);
        return user;
    }

}
