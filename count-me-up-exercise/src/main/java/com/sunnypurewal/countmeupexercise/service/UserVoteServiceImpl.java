package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.model.User;
import com.sunnypurewal.countmeupexercise.dao.CandidateRegistry;
import com.sunnypurewal.countmeupexercise.dao.UserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVoteServiceImpl implements UserVoteService {

    private UserRegistry userRegistry;
    private CandidateRegistry candidateRegistry;

    @Autowired
    public UserVoteServiceImpl(UserRegistry userRegistry, CandidateRegistry candidateRegistry) {
        this.userRegistry = userRegistry;
        this.candidateRegistry = candidateRegistry;
    }

    @Override
    public void submitVote(String userId, User user, String candidateId) {
        userRegistry.submitVote(userId, user);
        candidateRegistry.incrementVoteForCandidate(candidateId);
    }
}
