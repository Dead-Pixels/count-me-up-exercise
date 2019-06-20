package com.sunnypurewal.countmeupexercise.controller;

import com.sunnypurewal.countmeupexercise.customexceptions.candidate.CandidateMalformedRequestException;
import com.sunnypurewal.countmeupexercise.customexceptions.candidate.CandidateNotFoundException;
import com.sunnypurewal.countmeupexercise.model.Candidate;
import com.sunnypurewal.countmeupexercise.service.CandidateService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CandidateControllerTest {

    @Mock
    private CandidateService candidateService;
    @InjectMocks
    private CandidateController candidateController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = CandidateMalformedRequestException.class)
    public void addCandidate_objectHasNullField_shouldThrowException() {
        Candidate candidate = new Candidate(null, "Musk");
        candidateController.addCandidate("ElonMusk", candidate);
        fail("Should throw CandidateMalformedRequestException");
    }

    @Test
    public void addCandidate_standardCandidate_shouldNotThrowException() {
        Candidate candidate = new Candidate("Elon", "Musk");
        when(candidateService.addCandidate("ElonMusk", candidate)).thenReturn(new Candidate("Elon", "Musk"));
        assertNotNull(candidateController.addCandidate("ElonMusk", candidate));
    }

    @Test(expected = CandidateNotFoundException.class)
    public void getAllCandidates_noCandidatesExist_shouldThrowException() {
        Map<String, Candidate> candidates = candidateController.getAllCandidates();
        fail("Should throw CandidateNotFoundException");
    }

    @Test
    public void getAllCandidates_candidatesExist_shouldNotThrowException() {
        Map<String,Candidate> testCandidates = new HashMap<>();
        testCandidates.put("candidateOne", new Candidate("John", "Doe"));
        testCandidates.put("candidateTwo", new Candidate("Mark", "Bell"));
        testCandidates.put("candidateThree", new Candidate("Lucy", "Lazer"));

        when(candidateService.getAllCandidates()).thenReturn(testCandidates);
        Map<String, Candidate> returnedCandidates = candidateController.getAllCandidates();
        assertFalse(returnedCandidates.isEmpty());
        assertEquals("Lazer", returnedCandidates.get("candidateThree").getLastName());
    }



    @Test(expected = CandidateNotFoundException.class)
    public void getCandidate_candidateDoesNotExist_shouldThrowException() {
        candidateController.getCandidate("ElonNull");
        fail("Should throw CandidateNotFoundException");
    }

    @Test
    public void getCandidate_candidateExists_ShouldNotThrowException() {
        when(candidateService.getCandidate("ElonMusk")).thenReturn(new Candidate("Elon","Musk"));
        assertEquals("Musk", candidateController.getCandidate("ElonMusk").getLastName());
    }

    @Test(expected = CandidateNotFoundException.class)
    public void removeCandidate_candidateDoesNotExist_shouldThrowException() {
        when(candidateService.getCandidate("ElonMusk")).thenReturn(null);
        candidateController.removeCandidate("ElonMusk");
        fail("Should throw CandidateNotFoundException");
    }

    @Test
    public void removeCandidate_candidateExists_shouldNotThrowException() {
        when(candidateService.getCandidate("ElonMusk")).thenReturn(new Candidate("Elon", "Musk"));
        candidateController.removeCandidate("ElonMusk");
    }

    @Test(expected = CandidateNotFoundException.class)
    public void updateCandidate_candidateDoesNotExist_shouldThrowException() {
        when(candidateService.getCandidate("ElonMusk")).thenReturn(null);
        candidateController.updateCandidate("ElonMusk",new Candidate("Pool", "Shark"));
        fail("Should throw CandidateNotFoundException");
    }

    @Test
    public void updateCandidate_candidateExists_shouldNotThrowException() {
        Candidate newCandidate = new Candidate("Pika","Chu");

        when(candidateService.getCandidate("ElonMusk")).thenReturn(new Candidate("Elon","Musk"));
        when(candidateService.updateCandidate("ElonMusk", newCandidate))
                .thenReturn(new Candidate("Pika","Chu"));

        candidateController.updateCandidate("ElonMusk", newCandidate);
        assertEquals("Chu", candidateController
                .updateCandidate("ElonMusk", newCandidate).getLastName());
    }
}