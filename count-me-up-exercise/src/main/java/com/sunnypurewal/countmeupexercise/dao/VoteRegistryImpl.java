package com.sunnypurewal.countmeupexercise.dao;

import com.sunnypurewal.countmeupexercise.Model.Candidate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class VoteRegistryImpl implements VoteRegistry {
    //split into Vote registry where counts per candidate are collected and processed and userregistery where users are
    //registered and the number of votes they have made are collected

    private Map<Candidate, Integer> candidateList;

    public VoteRegistryImpl() {
        this.candidateList = new HashMap<>();
    }

    @Override
    public void registerCandidate(Candidate candidate){
        candidateList.put(candidate, 0);
    }

    @Override
    public void processVotes() {

    }

    @Override
    public void getResults() {

    }

    @Override
    public void getWinner() {

    }
    // TODO: 2019-06-17 this object will store collected votes for each candidate

}
