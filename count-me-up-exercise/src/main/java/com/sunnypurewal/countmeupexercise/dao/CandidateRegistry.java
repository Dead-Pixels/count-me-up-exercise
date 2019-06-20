package com.sunnypurewal.countmeupexercise.dao;

import com.sunnypurewal.countmeupexercise.model.Candidate;

import java.util.Map;

public interface CandidateRegistry {

    Candidate addCandidate(String candidateId, Candidate candidate);

    Map<String, Candidate>  getAllCandidates();

    Candidate getCandidate(String candidateId);

    Candidate updateCandidate(String candidateId, Candidate candidate);

    void removeCandidate(String candidateId);

    void incrementVoteForCandidate(String candidateId);

}
