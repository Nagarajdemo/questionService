package com.example.questionservice.service;

import com.example.questionservice.dao.QuestionDAO;
import com.example.questionservice.dao.QuizDao;
import com.example.questionservice.model.Question;
import com.example.questionservice.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDAO questionDAO;





    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questionList=questionDAO.getRandomQuestions(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionList);
        quizDao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}
