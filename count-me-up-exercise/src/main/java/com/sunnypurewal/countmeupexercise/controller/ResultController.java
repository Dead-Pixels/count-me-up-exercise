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

    //initially I was going to have this combined with the candidate controller because ultimately
    //Based on the assumption that this service is just going to collect and process votes all we really need is
    // the ability to vote and then to generate results. But I thought if this were to be expanded on its a little
    //spagetti like so it would just be better to seperate them out into their own individual classes

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
