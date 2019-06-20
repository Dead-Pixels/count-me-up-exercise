package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.dao.UserRegistryDao;
import com.sunnypurewal.countmeupexercise.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserVoteServiceImplTest {

@Mock
private UserRegistryDao userRegistryDao;

@InjectMocks
private UserVoteServiceImpl userVoteService;

    @Test
    public void getUser_standardUser_shouldReturnZuck() {
        User user = new User("Mark", "Zuck");
        when(userRegistryDao.getUser("MarkZuck")).thenReturn(new User("Mark","Zuck"));
        User retrievedUser = userVoteService.getUser("MarkZuck");

        assertEquals("Zuck", retrievedUser.getLastName());
    }
}