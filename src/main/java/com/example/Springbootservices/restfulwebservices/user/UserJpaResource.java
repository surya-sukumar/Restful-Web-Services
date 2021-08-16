package com.example.Springbootservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/jpa/users")
    public List<User> users(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> getUserById(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent())
            throw new UserNotFoundException("id-"+id);

        //Providing Link to All Users
        //Resource<T> --- EntityModel<T>
        EntityModel<User> resource = new EntityModel<User>(user.get());//Creating Resource with User class
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).users());//Adding link to "/users"
        resource.add(link.withRel("all-users"));//Adding the link to the resource
        //HATEOAS

        return resource;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        //return status and the user added
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void delete(@PathVariable int id){
        userRepository.deleteById(id);
    }

}
