package com.example.questionservice.controller;

import com.example.questionservice.model.Question;
import com.example.questionservice.service.QuestionService;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
 QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return  questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>>getByCatergory(@PathVariable String category){
        return questionService.getByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestions(@RequestBody Question question){
        return questionService.addQuestion(question);

    }
}


