package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.dao.CandidateRegistry;
import com.sunnypurewal.countmeupexercise.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ResultServiceImpl implements ResultService {

    private CandidateRegistry candidateRegistry;

    @Autowired
    public ResultServiceImpl(CandidateRegistry candidateRegistry) {
        this.candidateRegistry = candidateRegistry;
    }

    @Override
    public Map<String, Candidate> generateResults() {
        // The idea here is to process the results as efficiently as possible
        // Populate a Results object with the generated data
        // Return this object which will be returned in a JSON format
        Map<String, Candidate> candidates = candidateRegistry.getAllCandidates();

        int totalVotes = getTotalNumberOfVotes(candidates);

        buildResults(totalVotes, candidates);

        return candidates;
    }

    public int getTotalNumberOfVotes(Map<String, Candidate> candidates) {
        int totalVotes = 0;

        for (Map.Entry<String, Candidate> candidate : candidates.entrySet()) {
            totalVotes += candidate.getValue().getTotalNumberOfVotes();
        }
        return totalVotes;
    }

    public void buildResults(int totalVotes, Map<String, Candidate> candidates) {
        //We will be returning the map object which will be converted to json
        //We are using this method to work out the percentage of votes each candidate has and populating each candidate object
        //respectively
        for (Map.Entry<String, Candidate> candidate : candidates.entrySet()) {
            double totalNumberOfCandidateVotes = candidate.getValue().getTotalNumberOfVotes();
            double percentage = Math.round((totalNumberOfCandidateVotes / totalVotes) * 100);
            candidate.getValue().setPercentageOfVotes((int)percentage);
        }
    }
}