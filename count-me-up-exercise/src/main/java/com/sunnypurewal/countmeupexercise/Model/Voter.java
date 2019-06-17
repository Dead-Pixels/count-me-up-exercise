package com.sunnypurewal.countmeupexercise.Model;

import org.springframework.beans.factory.annotation.Value;

public class Voter {

    private String username;
    private int voteCount = 0;
    @Value("${total.votes.allowed}")
    private int totalVotesAllowed;

    public Voter(String username, int voteCount) {
        this.username = username;
        this.voteCount = voteCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "username='" + username + '\'' +
                ", voteCount=" + voteCount +
                ", totalVotesAllowed=" + totalVotesAllowed +
                '}';
    }


}
