package com.example.Springbootservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/users")
    public List<User> users(){
        return userDaoService.getUsers();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getOneUser(@PathVariable int id){
        User user = userDaoService.findOne(id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);

        //Providing Link to All Users
        //Resource<T> --- EntityModel<T>
        EntityModel<User> resource = new EntityModel<User>(user);//Creating Resource with User class
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).users());//Adding link to "/users"
        resource.add(link.withRel("all-users"));//Adding the link to the resource
        //HATEOAS

        return resource;
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

    //(@RequestHeader(name = "Accept-Language", required = false) Locale locale) instead of this
    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(){
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }

}
