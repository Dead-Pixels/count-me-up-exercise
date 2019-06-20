package com.sunnypurewal.countmeupexercise.model;

import org.springframework.beans.factory.annotation.Value;

public class User {

    private String firstName;
    private String lastName;
    private String age;
    private int voteCount = 0;
    @Value("${total.votes.allowed}")
    private int totalVotesAllowed;

    public User(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public boolean incrementCount() {
        if (voteCount + 1 < totalVotesAllowed) {
            this.voteCount++;
            return true;
        }
        return false;
    }
}
