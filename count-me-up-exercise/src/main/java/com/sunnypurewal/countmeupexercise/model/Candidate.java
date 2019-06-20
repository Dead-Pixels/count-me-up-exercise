package com.sunnypurewal.countmeupexercise.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Candidate {


    private String firstName;
    private String lastName;
    private int totalNumberOfVotes = 0;
    private int percentageOfVotes = 0;

    @JsonCreator
    public Candidate(String firstname, String lastName) {
        this.firstName = firstname;
        this.lastName = lastName;
    }

    public Candidate(String firstname, String lastName, int totalNumberOfVotes) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.totalNumberOfVotes = totalNumberOfVotes;
    }

    public Candidate(String firstname, String lastName, int totalNumberOfVotes, int percentageOfVotes) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.totalNumberOfVotes = totalNumberOfVotes;
        this.percentageOfVotes = percentageOfVotes;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTotalNumberOfVotes() {
        return totalNumberOfVotes;
    }

    public void setTotalNumberOfVotes(int totalNumberOfVotes) {
        this.totalNumberOfVotes = totalNumberOfVotes;
    }

    public int getPercentageOfVotes() {
        return percentageOfVotes;
    }

    public void setPercentageOfVotes(int percentageOfVotes) {
        this.percentageOfVotes = percentageOfVotes;
    }

    public void incrementVotes(){
        this.totalNumberOfVotes++;
    }
}
