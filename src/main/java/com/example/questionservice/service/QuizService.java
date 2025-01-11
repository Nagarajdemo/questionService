package com.example.questionservice.service;

import com.example.questionservice.dao.QuestionDAO;
import com.example.questionservice.dao.QuizDao;
import com.example.questionservice.model.Question;
import com.example.questionservice.model.QuestionWrapper;
import com.example.questionservice.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questionList=quiz.get().getQuestions();
        List<QuestionWrapper> questionWrapperList=new ArrayList<>();
        for(Question question:questionList) {
            QuestionWrapper questionWrapper=new QuestionWrapper(question.getId(),question.getQuestionTitle(),question.getCategory(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4(),question.getDifficultlevel());
            questionWrapperList.add(questionWrapper);
        }
        return new ResponseEntity<>(questionWrapperList, HttpStatus.OK);
    }
}
