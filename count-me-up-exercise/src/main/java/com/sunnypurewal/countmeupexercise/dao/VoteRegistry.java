package com.sunnypurewal.countmeupexercise.dao;

import com.sunnypurewal.countmeupexercise.Model.Candidate;

public interface VoteRegistry {

    void registerCandidate(Candidate candidate);

    void processVotes();

    void getResults();

    void getWinner();
}
