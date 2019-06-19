package com.sunnypurewal.countmeupexercise.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRegistryImplTest {

    private UserRegistryDao userRegistry;

    @Before
    public void before(){
        userRegistry = new UserRegistryDao();
    }

//    @Test
//    public void registerUser_userAdded_userShouldExist() {
//        userRegistry.registerUser("Username1", 0);
////        userRegistry.
////        assertNotNull(userRegistry);
//        fail("No test implemented");
//    }

    @Test
    public void registerUser_userNotAdded_userShouldShouldNotExist() {
        assertNull(userRegistry);
        fail("No test implemented");
    }

//    @Test
//    public void registerUser_attemptToAddInvalidUser_userShouldShouldNotExist() {
//        userRegistry.registerUser(" ", 0);
//        assertEquals();
//        fail("No test implemented");
//    }

    @Test
    public void getUser_userExists_shouldReturnUser() {
        fail("No test implemented");
    }

    @Test
    public void getUser_userDoesNotExist_shouldNotReturnUser() {
        fail("No test implemented");
    }

    @Test
    public void checkNumberOfVotes() {
        fail("No test implemented");
    }
}