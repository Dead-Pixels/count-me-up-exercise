package com.sunnypurewal.countmeupexercise.model;

import com.fasterxml.jackson.annotation.JsonCreator;


public class User {

    private String firstName;
    private String lastName;
    private int voteCount = 0;

    @JsonCreator
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, int voteCount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.voteCount = voteCount;
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

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public void incrementCount() {
            this.voteCount++;
    }
}
