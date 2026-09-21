package main.java.dsaarena.repository;

import main.java.dsaarena.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private Map<Long , User> users;
    public UserRepository(){
        users = new HashMap<>();
    }

    //add users
    public void addUser(User user){
        if(user == null){
            return;
        }
        users.put(user.getId() , user);
    }

    //get user by id
    public User getUserById(long userId){
        return users.get(userId);
    }

    //get all users
    public List<User> getAllUsers(){
        return new ArrayList<>(users.values());
    }

    //remove user by id
    public User removeUser(long userId){
        return users.remove(userId);
    }
}
