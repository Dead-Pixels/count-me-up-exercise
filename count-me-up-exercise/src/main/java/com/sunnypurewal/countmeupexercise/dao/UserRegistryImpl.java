package com.sunnypurewal.countmeupexercise.dao;

import com.sunnypurewal.countmeupexercise.Model.Voter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRegistryImpl implements UserRegistry {

    // TODO: 2019-06-17 Store users that have registered their votes

    Map<Voter, Integer> voterList;

    public UserRegistryImpl() {
        voterList = new HashMap<>();
    }

    @Override
    public void registerUser() {

    }

    @Override
    public void getUser() {

    }

    @Override
    public void checkNumberOfVotes() {

    }
}
