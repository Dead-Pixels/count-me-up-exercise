package com.sunnypurewal.countmeupexercise.dao;

import com.sunnypurewal.countmeupexercise.Model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRegistryDao implements UserRegistry {

// TODO: 2019-06-17 Store users that have registered their votes

    //Assumption: I could have created a user object here but that to me seemed like over engineering the solution
    //We just need a record of unique identifiers for all users and the number of times in which they voted
    //The preference is to keep implementation as simple as possible and add complexity with growth and where required
    //Assumption: Users must log in to vote with unique usernames which is why UUID has not been implemented here

    //maybe change map to <UUID, user> later?

    Map<String, User> userList;

    public UserRegistryDao() {
        userList = new HashMap<>();
    }

    @Override
    public void registerUser(String username, User user) {
        userList.put(username, user);
    }

    @Override
    public User getUser(String username) {
       return userList.get(username);
    }

    @Override
    public int checkNumberOfVotes(String username) {
        User user = getUser(username);
        return user.getVoteCount();
    }
}
