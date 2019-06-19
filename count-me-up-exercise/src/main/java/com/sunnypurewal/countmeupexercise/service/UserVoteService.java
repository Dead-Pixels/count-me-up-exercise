package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.Model.Candidate;

public interface UserVoteService {

    void submitVote(String candidateId, Candidate candidate);

}
