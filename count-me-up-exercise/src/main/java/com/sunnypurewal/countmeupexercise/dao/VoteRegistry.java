package com.sunnypurewal.countmeupexercise.dao;

import com.sunnypurewal.countmeupexercise.Model.Candidate;

import java.util.Map;

public interface VoteRegistry {

    void addCandidate(String candidateId, Candidate candidate);

    Map<String, Candidate>  getAllCandidates();

    Candidate getCandidate(String candidateId);

    void updateCandidate(String candidateId, Candidate candidate);

    void removeCandidate(String candidateId);

    void processVotes(String candidateId, int numberOfVotes);

    Map<String, Candidate> getResults();

    void getWinner();
}
