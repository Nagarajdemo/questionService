package com.example.questionservice.controller;

import com.example.questionservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;


    @GetMapping("quiz")
    public ResponseEntity<String> getQuiz() {
        return new ResponseEntity<>("Quiz controller", HttpStatus.OK);
    }

    @PostMapping("createQuiz")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        quizService.createQuiz(category,numQ,title);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }
}
