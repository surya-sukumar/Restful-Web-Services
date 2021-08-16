/*package com.example.Springbootservices.restfulwebservices.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserDAOService userDAOService;//inserting the user

    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);// log info

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Surya","Backend");//Adding user
        //New user is added User{id=1, name='Surya', tech='Backend'}
        long insert = userDAOService.insert(user);
        logger.info("New user is added "+user);
    }
}
*/