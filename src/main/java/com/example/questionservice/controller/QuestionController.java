package com.example.questionservice.controller;

import com.example.questionservice.model.Question;
import com.example.questionservice.service.QuestionService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
 QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return  questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question>getByCatergory(@PathVariable String category){
        return questionService.getByCategory(category);
    }

    @PostMapping("add")
    public String addQuestions(@RequestBody Question question){
        return questionService.addQuestion(question);

    }
}


