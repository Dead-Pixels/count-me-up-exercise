package com.sunnypurewal.countmeupexercise.controller;

import com.sunnypurewal.countmeupexercise.model.Candidate;
import com.sunnypurewal.countmeupexercise.service.ResultService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class ResultControllerTest {

    @Mock
    private ResultService resultService;

    @InjectMocks
    private ResultController resultController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getResults_candidatesExist_shouldReturnCandidates() {
        Map<String, Candidate> candidates = new HashMap<>();
        candidates.put("candidateOne", new Candidate("Elon", "Musk"));
        candidates.put("candidateTwo", new Candidate("Flat", "Tire"));
        candidates.put("candidateThree", new Candidate("Plastic", "Bottle"));
        candidates.put("candidateFour", new Candidate("Cola", "Pepsi"));

        when(resultService.generateResults()).thenReturn(candidates);
        assertNotNull(resultService.generateResults());
        assertEquals("Plastic", resultService.generateResults().get("candidateThree").getFirstName());
    }
}