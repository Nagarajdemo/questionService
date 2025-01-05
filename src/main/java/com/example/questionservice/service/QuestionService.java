package com.example.questionservice.service;

import com.example.questionservice.dao.QuestionDAO;
import com.example.questionservice.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDAO.save(question);
            return new ResponseEntity<>("successfully saved",HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("failure",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDAO.getQuestionByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
}
