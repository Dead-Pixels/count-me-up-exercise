package com.sunnypurewal.countmeupexercise.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gameshow/candidates")
public class VoteControllerImpl implements VoteController {

    @GetMapping("/submit")
    public String submitvote() {
        return "hello-world";
    }


    @PutMapping("")
    public void changeVote() {

    }


    @GetMapping("")
    public void getVotes(){

    }

    @DeleteMapping
    public void deleteVote() {
        // TODO: 2019-06-17 need to get data and remove

    }


}
