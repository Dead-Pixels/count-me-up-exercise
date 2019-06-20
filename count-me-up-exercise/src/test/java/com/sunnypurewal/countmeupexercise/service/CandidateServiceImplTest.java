package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.dao.CandidateRegistryDao;
import com.sunnypurewal.countmeupexercise.model.Candidate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class CandidateServiceImplTest {

    @Mock
    private CandidateRegistryDao candidateRegistry;
    @InjectMocks
    private CandidateServiceImpl candidateService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addCandidate_standardCandidate_shouldReturnCandidateObject() {
        Candidate candidate = new Candidate("John", "Wick");
        when(candidateRegistry.addCandidate("JohnWick", candidate)).thenReturn(new Candidate("John", "Wick"));
        Candidate createdCandidate = candidateService.addCandidate("JohnWick", candidate);
        assertEquals(candidate.getFirstName(), createdCandidate.getFirstName());

    }

    @Test
    public void getAllCandidates_mockCandidates_ShouldReturnAllCorrectFirstNames() {
        Map<String, Candidate> candidates = new HashMap<>();
        candidates.put("JohnWick", new Candidate("John", "Wick", 10));
        candidates.put("TonyStark", new Candidate("Tony", "Stark", 20));
        candidates.put("CarolDanvers", new Candidate("Carol", "Danvers", 30));
        candidates.put("JeanGrey", new Candidate("Jean", "Grey", 10));
        candidates.put("BruceBanner", new Candidate("Bruce", "Banner", 30));

        when(candidateRegistry.getAllCandidates()).thenReturn(candidates);
        Map<String, Candidate> allCandidates = candidateService.getAllCandidates();

        assertEquals("John", allCandidates.get("JohnWick").getFirstName());
        assertEquals("Tony", allCandidates.get("TonyStark").getFirstName());
        assertEquals("Carol", allCandidates.get("CarolDanvers").getFirstName());
        assertEquals("Jean", allCandidates.get("JeanGrey").getFirstName());
        assertEquals("Bruce", allCandidates.get("BruceBanner").getFirstName());
    }

    @Test
    public void getCandidate_standardCandidate_ShouldReturnCorrectCandidate() {
        Candidate candidate = new Candidate("John", "Wick");
        when(candidateRegistry.getCandidate("JohnWick")).thenReturn(new Candidate("John", "Wick"));
        Candidate retrievedCandidate = candidateService.getCandidate("JohnWick");
        assertEquals(candidate.getFirstName(), retrievedCandidate.getFirstName());
    }

    @Test
    public void updateCandidate_updateCandidateLastName_shouldReturnBurke() {
        Candidate candidate = new Candidate("John", "Burke");
        when(candidateRegistry.updateCandidate("JohnWick", candidate)).thenReturn(new Candidate("John", "Burke"));

        Candidate updatedCandidate = candidateService.updateCandidate("JohnWick", candidate);
        assertEquals("Burke", updatedCandidate.getLastName());
    }
}