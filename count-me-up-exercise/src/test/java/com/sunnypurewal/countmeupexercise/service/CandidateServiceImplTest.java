package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.dao.CandidateRegistry;
import com.sunnypurewal.countmeupexercise.model.Candidate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CandidateServiceImplTest {

    @Mock
    private CandidateRegistry candidateRegistry;
    @InjectMocks
    private CandidateServiceImpl candidateService;
    private Candidate candidate;

    @Before
    public void before() {
        candidate = new Candidate("John", "Wick");
    }

    @Test
    public void addCandidate() {
//        candidateService.addCandidate("JohnWick");
//        Candidate returnedCandidate = candidateService.getCandidate("JohnWick");
//        assertEquals(candidate, returnedCandidate);
    }

    @Test
    public void getAllCandidates() {
    }

    @Test
    public void setCandidateRegistry() {
    }

    @Test
    public void getCandidate() {
    }

    @Test
    public void updateCandidate() {
    }

    @Test
    public void removeCandidate() {
    }
}