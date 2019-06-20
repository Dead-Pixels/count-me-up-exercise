package com.sunnypurewal.countmeupexercise.controller;

import com.sunnypurewal.countmeupexercise.customexceptions.User.UserExceedVoteException;
import com.sunnypurewal.countmeupexercise.customexceptions.User.UserMalformedRequestException;
import com.sunnypurewal.countmeupexercise.customexceptions.candidate.CandidateNotFoundException;
import com.sunnypurewal.countmeupexercise.model.Candidate;
import com.sunnypurewal.countmeupexercise.model.User;
import com.sunnypurewal.countmeupexercise.service.CandidateService;
import com.sunnypurewal.countmeupexercise.service.UserVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gameshow")
public class UserVoteController {


    private UserVoteService userVoteService;
    private CandidateService candidateService;
    @Value("${total.votes.allowed}")
    private int totalVotesAllowed = 3;

    @Autowired
    public UserVoteController(UserVoteService userVoteService, CandidateService candidateService) {
        this.userVoteService = userVoteService;
        this.candidateService = candidateService;
    }

    //User can only perform one vote at a time
    @PutMapping("/users/{userId}/{candidateId}")
    public void submitVote(@PathVariable String userId, @RequestBody User user, @PathVariable String candidateId) {
        if (user.getFirstName() == null || user.getLastName() == null) {
            throw new UserMalformedRequestException("Please check parameters");
        }

        Candidate candidate = candidateService.getCandidate(candidateId);
        if (candidate == null) {
            throw new CandidateNotFoundException("Candidate not found + " + candidateId);
        }

        User userFromDao = userVoteService.getUser(userId);

        //Basically checking if the user exists and has reached the vote limit
        if (userFromDao != null && (userFromDao.getVoteCount() == totalVotesAllowed)) {
            throw new UserExceedVoteException("Max vote limit has been reached for user");
        }
        userVoteService.submitVote(userId, user, candidateId);
    }
}