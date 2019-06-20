package com.sunnypurewal.countmeupexercise.controller;

import com.sunnypurewal.countmeupexercise.customexceptions.candidate.CandidateMalformedRequestException;
import com.sunnypurewal.countmeupexercise.customexceptions.candidate.CandidateNotFoundException;
import com.sunnypurewal.countmeupexercise.model.Candidate;
import com.sunnypurewal.countmeupexercise.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/gameshow")
public class CandidateController {

    //Simple controller to add new candidates rather than having a hardcoded specific amount of candidates availible
    //For our use case we will be working with a sample set of 5 as per the example given
    //Creating CRUD operations for candidates

    private CandidateService candidateVoteService;

    @Autowired
    public CandidateController(CandidateService candidateVoteService) {
        this.candidateVoteService = candidateVoteService;
    }

    @PostMapping("/candidates/{candidateId}")
    public Candidate addCandidate(@PathVariable String candidateId, @RequestBody Candidate candidate) {
        if(candidate.getFirstName() == null || candidate.getLastName() == null){
            throw new CandidateMalformedRequestException("Please check request parameters, may be null");
        }
        return candidateVoteService.addCandidate(candidateId, candidate);
    }

    @GetMapping("/candidates")
    public Map<String, Candidate> getAllCandidates() {
        Map<String, Candidate> candidates = candidateVoteService.getAllCandidates();
        if (candidates.isEmpty()) {
            throw new CandidateNotFoundException("Candidates not found");
        }
        return candidates;
    }

    @GetMapping("/candidates/{candidateId}")
    public Candidate getCandidate(@PathVariable String candidateId) {
        Candidate candidate = candidateVoteService.getCandidate(candidateId);
        if (candidate == null) {
            throw new CandidateNotFoundException("Candidate not found: " + candidateId);
        }
        return candidate;
    }

    @DeleteMapping("/candidates/{candidateId}")
    public void removeCandidate(@PathVariable String candidateId) {
        Candidate candidate= getCandidate(candidateId);
        if(candidate == null){
            throw new CandidateNotFoundException("Candidate not found: " + candidateId);
        }
        candidateVoteService.removeCandidate(candidateId);
    }

    @PutMapping("/candidates/{candidateId}")
    public Candidate updateCandidate(@PathVariable String candidateId, @RequestBody Candidate candidate) {
        Candidate candidateFromDao = getCandidate(candidateId);
        if(candidateFromDao == null){
            throw new CandidateNotFoundException("Candidtate not found: " + candidateId);
        }
        return candidateVoteService.updateCandidate(candidateId, candidate);
    }
}
