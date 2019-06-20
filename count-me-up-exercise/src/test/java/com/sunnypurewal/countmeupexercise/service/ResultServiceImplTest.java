package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.dao.CandidateRegistry;
import com.sunnypurewal.countmeupexercise.model.Candidate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ResultServiceImplTest {

    @Mock
    private CandidateRegistry candidateRegistry;
    @InjectMocks
    private ResultServiceImpl resultService;

    private Map<String, Candidate> candidates;

    @Test
    public void generateResults_TotalOfHundredVotes_allPercentageOfVotesShouldBeCorrect() {
        candidates = new HashMap<>();
        candidates.put("JohnWick", new Candidate("John","Wick", 10));
        candidates.put("TonyStark", new Candidate("Tony","Stark", 20));
        candidates.put("CarolDanvers", new Candidate("Carol","Danvers", 30));
        candidates.put("JeanGrey", new Candidate("Jean","Grey", 10));
        candidates.put("BruceBanner", new Candidate("Bruce","Banner", 30));

        when(candidateRegistry.getAllCandidates()).thenReturn(candidates);
        Map<String, Candidate> results = resultService.generateResults();

        assertEquals(10, results.get("JohnWick").getPercentageOfVotes());
        assertEquals(20, results.get("TonyStark").getPercentageOfVotes());
        assertEquals(30, results.get("CarolDanvers").getPercentageOfVotes());
        assertEquals(10, results.get("JeanGrey").getPercentageOfVotes());
        assertEquals(30, results.get("BruceBanner").getPercentageOfVotes());
    }

    @Test
    public void generateResults_TotalOfTenMillionVotes_allPercentageOfVotesShouldBeCorrect() {
        candidates = new HashMap<>();
        candidates.put("JohnWick", new Candidate("John","Wick", 1500000));
        candidates.put("TonyStark", new Candidate("Tony","Stark", 2500000));
        candidates.put("CarolDanvers", new Candidate("Carol","Danvers", 5000000));
        candidates.put("JeanGrey", new Candidate("Jean","Grey", 500000));
        candidates.put("BruceBanner", new Candidate("Bruce","Banner", 500000));

        when(candidateRegistry.getAllCandidates()).thenReturn(candidates);
        Map<String, Candidate> results = resultService.generateResults();

        assertEquals(15, results.get("JohnWick").getPercentageOfVotes());
        assertEquals(25, results.get("TonyStark").getPercentageOfVotes());
        assertEquals(50, results.get("CarolDanvers").getPercentageOfVotes());
        assertEquals(5, results.get("JeanGrey").getPercentageOfVotes());
        assertEquals(5, results.get("BruceBanner").getPercentageOfVotes());
    }

    @Test
    public void generateResults_RandomNonWholeNumbers_allPercentageOfVotesShouldBeCorrect() {
        candidates = new HashMap<>();
        candidates.put("JohnWick", new Candidate("John","Wick", 15045600));
        candidates.put("TonyStark", new Candidate("Tony","Stark", 34509000));
        candidates.put("CarolDanvers", new Candidate("Carol","Danvers", 5009650));
        candidates.put("JeanGrey", new Candidate("Jean","Grey", 554320));
        candidates.put("BruceBanner", new Candidate("Bruce","Banner", 50));

        when(candidateRegistry.getAllCandidates()).thenReturn(candidates);
        Map<String, Candidate> results = resultService.generateResults();

        assertEquals(27, results.get("JohnWick").getPercentageOfVotes());
        assertEquals(63, results.get("TonyStark").getPercentageOfVotes());
        assertEquals(9, results.get("CarolDanvers").getPercentageOfVotes());
        assertEquals(1, results.get("JeanGrey").getPercentageOfVotes());
        assertEquals(0, results.get("BruceBanner").getPercentageOfVotes());
    }

    @Test
    public void getTotalNumberOfVotes_TotalOfHundred_shouldReturnTenMillion() {
        candidates = new HashMap<>();
        candidates.put("JohnWick", new Candidate("John","Wick", 10));
        candidates.put("TonyStark", new Candidate("Tony","Stark", 20));
        candidates.put("CarolDanvers", new Candidate("Carol","Danvers", 50));
        candidates.put("JeanGrey", new Candidate("Jean","Grey", 10));
        candidates.put("BruceBanner", new Candidate("Bruce","Banner", 10));

        assertEquals(100, resultService.getTotalNumberOfVotes(candidates));
    }

    //checking if response is under one second
    @Test(timeout=1000)
    public void getTotalNumberOfVotes_TotalOfTenMillion_shouldReturnTenMillion() {
        candidates = new HashMap<>();
        candidates.put("JohnWick", new Candidate("John","Wick", 1500000));
        candidates.put("TonyStark", new Candidate("Tony","Stark", 2500000));
        candidates.put("CarolDanvers", new Candidate("Carol","Danvers", 5000000));
        candidates.put("JeanGrey", new Candidate("Jean","Grey", 500000));
        candidates.put("BruceBanner", new Candidate("Bruce","Banner", 500000));

        assertEquals(10000000, resultService.getTotalNumberOfVotes(candidates));
    }



        //not testing build results method as this is already tested via generateResultsMethod
}