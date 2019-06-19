package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.Model.Candidate;
import com.sunnypurewal.countmeupexercise.dao.VoteRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateVoteServiceImpl implements CandidateVoteService {

    VoteRegistry voteRegistry;

    @Autowired
    public CandidateVoteServiceImpl(VoteRegistry voteRegistry) {
        this.voteRegistry = voteRegistry;
    }

    @Override
    public void addCandidate(String candidateId, Candidate candidate) {
        voteRegistry.addCandidate(candidateId, candidate);
    }

    @Override
    public void getAllCandidates() {
        voteRegistry.getAllCandidates();
    }

    @Override
    public void getCandidate(String candidateId) {
        voteRegistry.getCandidate(candidateId);
    }

    @Override
    public void updateCandidate(String candidateId, Candidate candidate) {
        voteRegistry.updateCandidate(candidateId, candidate);
    }

    @Override
    public void removeCandidate(String candidateId) {
        voteRegistry.removeCandidate(candidateId);
    }


}
