package com.sunnypurewal.countmeupexercise.dao;

import com.sunnypurewal.countmeupexercise.model.Candidate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CandidateRegistryDao implements CandidateRegistry {

    private Map<String, Candidate> candidateList;

    public CandidateRegistryDao() {
        this.candidateList = new HashMap<>();
    }

    public CandidateRegistryDao(Map<String, Candidate> candidateList) {
        this.candidateList = candidateList;
    }

    @Override
    public Candidate addCandidate(String candidateId, Candidate candidate){
         candidateList.put(candidateId, candidate);
         return candidate;
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

    //Votes are to be incremented by 1 each time
    @Override
    public int incrementVoteForCandidate(String candidateId){
        return getCandidate(candidateId).incrementVotes();
    }
}
