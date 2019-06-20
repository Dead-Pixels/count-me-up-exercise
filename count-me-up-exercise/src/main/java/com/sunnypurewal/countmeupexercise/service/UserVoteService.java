package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.model.User;

public interface UserVoteService {

    void submitVote(String userId, User user, String candidateId);

    User getUser(String userId);

}
