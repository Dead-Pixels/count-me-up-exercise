package com.sunnypurewal.countmeupexercise.dao;

import com.sunnypurewal.countmeupexercise.model.Candidate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CandidateRegistryDaoTest {

    private CandidateRegistryDao candidateRegistryDao;

    @Before
    public void setUp() {
        candidateRegistryDao = new CandidateRegistryDao();
    }

    @Test
    public void addCandidate_standardCandidate_candidateShouldExist() {
        candidateRegistryDao.addCandidate("JohnWick", new Candidate("John", "Wick"));
        assertEquals("John", candidateRegistryDao.getCandidate("JohnWick").getFirstName());
    }

    @Test
    public void getAllCandidates_addThreeCandidates_shouldReturnAllCandidates() {
        candidateRegistryDao.addCandidate("JohnWick", new Candidate("John", "Wick"));
        candidateRegistryDao.addCandidate("CarolDanvers", new Candidate("Carol", "Danvers"));
        candidateRegistryDao.addCandidate("TonyStark", new Candidate("Tony", "Stark"));

        assertEquals("Wick", candidateRegistryDao.getCandidate("JohnWick").getLastName());
        assertEquals("Danvers", candidateRegistryDao.getCandidate("CarolDanvers").getLastName());
        assertEquals("Stark", candidateRegistryDao.getCandidate("TonyStark").getLastName());
    }

    @Test
    public void getCandidate_standardCandidate_shouldReturnCandidate() {
        candidateRegistryDao.addCandidate("JohnWick", new Candidate("John", "Wick"));
        assertEquals("John", candidateRegistryDao.getCandidate("JohnWick").getFirstName());
    }

    @Test
    public void updateCandidate_changeCandidateNameToPikachu_shouldReturnPika() {
        candidateRegistryDao.addCandidate("JohnWick", new Candidate("John", "Wick"));
        candidateRegistryDao.updateCandidate("JohnWick", new Candidate("Pika", "Chu"));
        assertEquals("Pika", candidateRegistryDao.getCandidate("JohnWick").getFirstName());
    }

    @Test
    public void removeCandidate_standardCandidate_shouldReturnNull() {
        candidateRegistryDao.addCandidate("JohnWick", new Candidate("John", "Wick"));
        candidateRegistryDao.removeCandidate("JohnWick");
        assertEquals(null, candidateRegistryDao.getCandidate("JohnWick"));
    }

    @Test
    public void incrementVoteForCandidate_incrementVoteByOne_voteTotalShouldIncrement() {
        candidateRegistryDao.addCandidate("JohnWick", new Candidate("John", "Wick"));
        int numberOfVotes = candidateRegistryDao.incrementVoteForCandidate("JohnWick");
        assertEquals(1, numberOfVotes);
        numberOfVotes = candidateRegistryDao.incrementVoteForCandidate("JohnWick");
        assertEquals(2, numberOfVotes);
        numberOfVotes = candidateRegistryDao.incrementVoteForCandidate("JohnWick");
        assertEquals(3, numberOfVotes);

    }
}