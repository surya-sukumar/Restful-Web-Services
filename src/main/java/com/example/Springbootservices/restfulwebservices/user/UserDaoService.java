package com.example.Springbootservices.restfulwebservices.user;

//using static array to save data initially
import java.util.ArrayList;
import java.util.List;

public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private int userCount=3;
    static {
        users.add(new User(1, "Surya","Backend"));
        users.add(new User(2, "Vismitha","Full Stack"));
        users.add(new User(3, "Aditya","Front End"));
    }

    public static List<User> getUsers() {
        return users;
    }

    public User save(User user){
        if(user.getId()==0){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){

        for(User user:users){
            if(user.getId()==id)
                return user;
        }
        return null;
    }

}
