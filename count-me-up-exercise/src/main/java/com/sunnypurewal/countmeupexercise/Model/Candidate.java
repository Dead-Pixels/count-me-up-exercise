package com.sunnypurewal.countmeupexercise.Model;

public class Candidate {

    private String candidateName;
    private int totalNumberOfVotes = 0;

    public Candidate(String candidateName) {
        this.candidateName = candidateName;

    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getTotalNumberOfVotes() {
        return totalNumberOfVotes;
    }

    public void setTotalNumberOfVotes(int totalNumberOfVotes) {
        this.totalNumberOfVotes = totalNumberOfVotes;
    }

    public void incrementVotes(){

    }


}
