package com.sunnypurewal.countmeupexercise.controller;

import com.sunnypurewal.countmeupexercise.customexceptions.User.UserExceedVoteException;
import com.sunnypurewal.countmeupexercise.customexceptions.User.UserMalformedRequestException;
import com.sunnypurewal.countmeupexercise.customexceptions.candidate.CandidateNotFoundException;
import com.sunnypurewal.countmeupexercise.model.Candidate;
import com.sunnypurewal.countmeupexercise.model.User;
import com.sunnypurewal.countmeupexercise.service.CandidateServiceImpl;
import com.sunnypurewal.countmeupexercise.service.UserVoteServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class UserVoteControllerTest {

    @Mock
    private UserVoteServiceImpl userVoteService;
    @Mock
    private CandidateServiceImpl candidateService;

    @InjectMocks
    private UserVoteController userVoteController;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = UserMalformedRequestException.class)
    public void submitVote_userDetailsAreNull_shouldThrowException() {
        User user = new User(null, null);
        userVoteController.submitVote("candidateOne", user, "ElonMusk");
        fail("Should throw exception");
    }

    @Test(expected = CandidateNotFoundException.class)
    public void submitVote_candidateDoesNotExist_shouldThrowException() {
        User user = new User("John", "Doe");
        when(candidateService.getCandidate("ElonMusk")).thenReturn(null);
        userVoteController.submitVote("candidateOne", user, "ElonMusk");
        fail("Should throw exception");
    }

    @Test(expected = UserExceedVoteException.class)
    public void submitVote_maxUserVotesExceeded_shouldThrowException() {
        User user = new User("John", "Doe",3);
        when(candidateService.getCandidate("ElonMusk")).thenReturn(new Candidate("Elon", "Musk"));
        when(userVoteService.getUser("userOne")).thenReturn(user);
        userVoteController.submitVote("userOne", user, "ElonMusk");
        fail("Should throw exception");
    }

    @Test
    public void submitVote_validInformation_shouldNotThrowException(){
        User user = new User("John", "Doe",0);
        when(candidateService.getCandidate("ElonMusk")).thenReturn(new Candidate("Elon", "Musk"));
        when(userVoteService.getUser("userOne")).thenReturn(user);
        userVoteController.submitVote("userOne", user, "ElonMusk");
    }
}