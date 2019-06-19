package com.sunnypurewal.countmeupexercise.controller;

import com.sunnypurewal.countmeupexercise.Model.Candidate;
import com.sunnypurewal.countmeupexercise.service.CandidateVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gameshow")
public class CandidateControllerImpl {

    //Simple controller to add new candidates rather than having a hardcoded specific amount of candidates availible
    //For our use case we will be working with a sample set of 5 as per the example given
    //Creating CRUD operations for candidates

    private CandidateVoteService candidateVoteService;

    @Autowired
    public CandidateControllerImpl(CandidateVoteService candidateVoteService) {
        this.candidateVoteService = candidateVoteService;
    }

    @PostMapping("/candidates/{candidateId}")
    public boolean addCandidate(@PathVariable String candidateId, @RequestBody Candidate candidate) {
        candidateVoteService.addCandidate(candidateId, candidate);
        return true;
    }

    @GetMapping("/candidates")
    public void getAllCandidates() {
        candidateVoteService.getAllCandidates();
    }

    @GetMapping("/candidates/{candidateId}")
    public void getCandidate(@PathVariable String candidateId){
        candidateVoteService.getCandidate(candidateId);
    }

    @DeleteMapping("/candidates/{candidateId}")
    public void removeCandidate(@PathVariable String candidateId) {
        candidateVoteService.removeCandidate(candidateId);
    }

    @PutMapping("/candidates/{candidateId}")
    public void updateCandidate(@PathVariable String candidateId, @RequestBody Candidate candidate) {
        candidateVoteService.updateCandidate(candidateId, candidate);
    }


}
