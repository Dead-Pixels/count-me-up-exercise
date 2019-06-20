package com.sunnypurewal.countmeupexercise.controller;

import com.sunnypurewal.countmeupexercise.model.User;
import com.sunnypurewal.countmeupexercise.service.UserVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gameshow")
public class UserVoteController {
    //Since we are just passing in the use and whom they voted for the system will be kept simple in the fact once a vote
    //has been made it cannot be changed or deleted

    UserVoteService userVoteService;

    @Autowired
    public UserVoteController(UserVoteService userVoteService) {
        this.userVoteService = userVoteService;
    }

    @PostMapping("/users/{userId}/{candidateId}")
    public void submitVote(@PathVariable String userId, @RequestBody User user, @PathVariable String candidateId) {
        userVoteService.submitVote(userId, user, candidateId);
    }

}
