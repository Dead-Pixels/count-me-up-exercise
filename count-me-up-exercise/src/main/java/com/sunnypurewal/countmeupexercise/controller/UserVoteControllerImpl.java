package com.sunnypurewal.countmeupexercise.controller;

import com.sunnypurewal.countmeupexercise.Model.Candidate;
import com.sunnypurewal.countmeupexercise.service.UserVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gameshow")
public class UserVoteControllerImpl {
    //Since we are just passing in the use and whom they voted for the system will be kept simple in the fact once a vote
    //has been made it cannot be changed or deleted

    UserVoteService userVoteService;

    @Autowired
    public UserVoteControllerImpl(UserVoteService userVoteService) {
        this.userVoteService = userVoteService;
    }

    @PostMapping("/users/{candidateId}")
    public void submitVote(@PathVariable String candidateId, @RequestBody Candidate candidate) {
        userVoteService.submitVote(candidateId, candidate);
    }

}
