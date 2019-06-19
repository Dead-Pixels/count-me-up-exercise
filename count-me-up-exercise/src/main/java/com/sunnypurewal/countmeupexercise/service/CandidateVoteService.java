package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.Model.Candidate;

public interface CandidateVoteService {

    void addCandidate(String candidateId, Candidate candidate);

    void getAllCandidates();

    void getCandidate(String candidateId);

    void removeCandidate(String candidateId);

    void updateCandidate(String candidateId, Candidate candidate);
}
