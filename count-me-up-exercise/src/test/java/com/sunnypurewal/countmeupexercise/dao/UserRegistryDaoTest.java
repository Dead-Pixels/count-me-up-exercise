package com.sunnypurewal.countmeupexercise.dao;

import com.sunnypurewal.countmeupexercise.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRegistryDaoTest {

    private UserRegistryDao userRegistryDao;

    @Before
    public void setUp(){
        userRegistryDao = new UserRegistryDao();
    }

    @Test
    public void submitVote_submitWithNewUser_UserShouldBeRecorded() {
        User user = new User("Sunny", "Purewal");
        userRegistryDao.submitVote("userOne", user);
        assertEquals(user.getFirstName(), userRegistryDao.getUser("userOne").getFirstName());
        assertEquals(1, user.getVoteCount());
    }

    @Test
    public void getUser_newUser_ShouldReturnCreatedUser() {
        User user = new User("Sunny", "Purewal");
        userRegistryDao.submitVote("userOne", user);
        assertEquals(user.getFirstName(), userRegistryDao.getUser("userOne").getFirstName());
    }

    @Test
    public void findUser_existingUser_shouldReturnTrue() {
        User user = new User("Sunny", "Purewal");
        userRegistryDao.submitVote("userOne", user);
        assertEquals(true, userRegistryDao.findUser("userOne"));
    }

    @Test
    public void findUser_nonexistantUser_shouldReturnFalse() {
        assertEquals(false, userRegistryDao.findUser("userOne"));
    }

    @Test
    public void checkNumberOfVotes_submitThreeSuccessiveVotes_shouldIncrementVotes() {
        User user = new User("Sunny", "Purewal");
        userRegistryDao.submitVote("userOne", user);
        assertEquals(1, user.getVoteCount());
        userRegistryDao.submitVote("userOne", user);
        assertEquals(2, user.getVoteCount());
        userRegistryDao.submitVote("userOne", user);
        assertEquals(3, user.getVoteCount());
    }
}