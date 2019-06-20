package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.dao.CandidateRegistry;
import com.sunnypurewal.countmeupexercise.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CandidateServiceImpl implements CandidateService {

    private CandidateRegistry candidateRegistry;

    @Autowired
    public CandidateServiceImpl(CandidateRegistry voteRegistry) {
        this.candidateRegistry = voteRegistry;
    }

    @Override
    public Candidate addCandidate(String candidateId, Candidate candidate) {
        return candidateRegistry.addCandidate(candidateId, candidate);
    }

    @Override
    public Candidate getCandidate(String candidateId) {
        return candidateRegistry.getCandidate(candidateId);
    }

    @Override
    public Map<String, Candidate> getAllCandidates() {
        return candidateRegistry.getAllCandidates();
    }

    @Override
    public Candidate updateCandidate(String candidateId, Candidate candidate) {
        return candidateRegistry.updateCandidate(candidateId, candidate);
    }

    @Override
    public void removeCandidate(String candidateId) {
        Candidate candidate = getCandidate(candidateId);
        if (candidate != null) {
            candidateRegistry.removeCandidate(candidateId);
        }
    }


}
