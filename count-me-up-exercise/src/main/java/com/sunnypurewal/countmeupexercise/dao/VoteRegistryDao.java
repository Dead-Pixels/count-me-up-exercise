package com.sunnypurewal.countmeupexercise.dao;

import com.sunnypurewal.countmeupexercise.Model.Candidate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class VoteRegistryDao implements VoteRegistry {
    //split into Vote registry where counts per candidate are collected and processed and userregistery where users are
    //registered and the number of votes they have made are collected

    private Map<String, Candidate> candidateList;

    public VoteRegistryDao() {
        this.candidateList = new HashMap<>();
    }

    @Override
    public void addCandidate(String candidateId, Candidate candidate){
        candidateList.put(candidateId, candidate);
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
    public void updateCandidate(String candidateId, Candidate candidate) {
        candidateList.put(candidateId, candidate);
    }

    @Override
    public void removeCandidate(String candidateId) {
        candidateList.remove(candidateId);
    }





    @Override
    public void processVotes(String candidateId, int numberOfVotes) {
        Candidate candidate = candidateList.get(candidateId);
        candidate.incrementVotes();
    }

    @Override
    public Map<String, Candidate> getResults() {
        //get a curated list of results what I want to do is return this object as a json representation
        return candidateList;
    }

    @Override
    public void getWinner() {
        //get
    }
    // TODO: 2019-06-17 this object will store collected votes for each candidate

}
