package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.model.Candidate;

import java.util.Map;

public interface CandidateService {

    Candidate addCandidate(String candidateId, Candidate candidate);

    Map<String,Candidate> getAllCandidates();

    Candidate getCandidate(String candidateId);

    void removeCandidate(String candidateId);

    Candidate updateCandidate(String candidateId, Candidate candidate);
}
