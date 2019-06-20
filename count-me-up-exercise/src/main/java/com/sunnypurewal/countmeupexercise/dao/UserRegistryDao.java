package com.sunnypurewal.countmeupexercise.dao;

import com.sunnypurewal.countmeupexercise.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRegistryDao implements UserRegistry {

    Map<String, User> userList;

    public UserRegistryDao() {
        userList = new HashMap<>();
    }

    public void submitVote(String userId, User user) {
        //check if user exists
        if (findUser(userId)) {
            //increment count -> will only increment if under designated max votes (prechecked in controller)
            getUser(userId).incrementCount();
        } else {
            //create user
            registerUser(userId, user);
            //increment count for new user
            getUser(userId).incrementCount();
        }
    }

    public void registerUser(String userId, User user) {
        userList.put(userId, user);
    }

    public User getUser(String userId) {
        return userList.get(userId);
    }

    public boolean findUser(String userId) {
        User user = userList.get(userId);

        if (user != null) {
            return true;
        }
        return false;
    }

    public int checkNumberOfVotes(String userId) {
        User user = getUser(userId);
        return user.getVoteCount();
    }
}
