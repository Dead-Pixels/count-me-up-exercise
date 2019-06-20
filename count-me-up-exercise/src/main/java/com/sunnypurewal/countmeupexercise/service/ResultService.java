package com.sunnypurewal.countmeupexercise.service;

import com.sunnypurewal.countmeupexercise.model.Candidate;

import java.util.Map;

public interface ResultService {

    Map<String, Candidate> generateResults();
}
