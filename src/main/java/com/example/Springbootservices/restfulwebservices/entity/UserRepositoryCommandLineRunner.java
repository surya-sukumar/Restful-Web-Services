package com.example.Springbootservices.restfulwebservices.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;//inserting the user

    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);// log info

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Vismitha","Backend");//Adding user
        //New user is added User{id=1, name='Surya', tech='Backend'}
        userRepository.save(user);
        logger.info("New user is added "+user);
    }
}

