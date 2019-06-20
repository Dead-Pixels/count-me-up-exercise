package com.sunnypurewal.countmeupexercise.controller;

import com.sunnypurewal.countmeupexercise.model.Candidate;
import com.sunnypurewal.countmeupexercise.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/gameshow")
public class ResultController {
    //Initially I had the get results method as part of the user vote controller but it made more sense to
    //Seperate them out into individual controllers.

    private ResultService resultsService;

    @Autowired
    public ResultController(ResultService resultsService) {
        this.resultsService = resultsService;
    }

    @GetMapping("/results")
    public Map<String, Candidate> getResults(){
        return resultsService.generateResults();
    }

}
