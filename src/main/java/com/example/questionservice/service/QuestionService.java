package com.example.questionservice.service;

import com.example.questionservice.dao.QuestionDAO;
import com.example.questionservice.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;
    public List<Question> getAllQuestions() {
        return questionDAO.findAll();
    }
    public String addQuestion(Question question) {

        questionDAO.save(question);
        return "success";
    }

    public List<Question> getByCategory(String category) {
        return questionDAO.getQuestionByCategory(category);
    }
}
