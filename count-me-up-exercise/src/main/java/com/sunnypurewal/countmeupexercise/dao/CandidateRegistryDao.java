package com.sunnypurewal.countmeupexercise.dao;

import com.sunnypurewal.countmeupexercise.model.Candidate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CandidateRegistryDao implements CandidateRegistry {
    //split into Vote registry where counts per candidate are collected and processed and userregistery where users are
    //registered and the number of votes they have made are collected
    //I would have liked to maybe add the votes to a queue and have these votes multithread process votes
    // and update results continually
    //Assumption validation for usernames will be handled on the front end

    private Map<String, Candidate> candidateList;

    public CandidateRegistryDao() {
        this.candidateList = new HashMap<>();
    }

    public CandidateRegistryDao(Map<String, Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    @Override
    public Candidate addCandidate(String candidateId, Candidate candidate){
        return candidateList.put(candidateId, candidate);
    }

    @Override
    public Map<String, Candidate> getAllCandidates() {
        return candidateList;
    }

    @Override
    public Candidate getCandidate(String candidateId) {
        return candidateList.get(candidateId);
    }

    @Override
    public Candidate updateCandidate(String candidateId, Candidate candidate) {
        return candidateList.put(candidateId, candidate);
    }

    @Override
    public void removeCandidate(String candidateId) {
        candidateList.remove(candidateId);
    }

    @Override
    public void incrementVoteForCandidate(String candidateId){
        getCandidate(candidateId).incrementVotes();
    }
}
