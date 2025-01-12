package com.example.questionservice.controller;

import com.example.questionservice.model.Question;
import com.example.questionservice.model.QuestionWrapper;
import com.example.questionservice.service.QuizService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.questionservice.model.Response;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;


    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id) {
        return (quizService.getQuizQuestions(id));
    }

    @PostMapping("createQuiz")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        quizService.createQuiz(category,numQ,title);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }


    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitResponse(@PathVariable int id, @RequestBody List<Response> responses) {
       return  quizService.calculateReponse(id, responses);

    }
}
