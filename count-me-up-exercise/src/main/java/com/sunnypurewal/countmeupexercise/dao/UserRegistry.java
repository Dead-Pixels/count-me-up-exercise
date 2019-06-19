package com.sunnypurewal.countmeupexercise.dao;

import com.sunnypurewal.countmeupexercise.Model.User;

public interface UserRegistry {

    void registerUser(String username, User user);

    User getUser(String username);

    int checkNumberOfVotes(String username);

    }

