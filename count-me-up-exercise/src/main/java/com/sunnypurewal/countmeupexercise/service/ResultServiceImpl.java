package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.dao.ResultsDao;
import com.sunnypurewal.countmeupexercise.dao.VoteRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService {

    private VoteRegistry voteRegistry;
    private ResultsDao resultsDao;

    @Autowired
    public ResultServiceImpl(VoteRegistry voteRegistry, ResultsDao resultsDao) {
        this.voteRegistry = voteRegistry;
        this.resultsDao = resultsDao;
    }

    public void generateResults(){

    }



}
