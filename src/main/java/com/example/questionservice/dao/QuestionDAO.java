package com.example.questionservice.dao;

import com.example.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
    List<Question> getQuestionByCategory(String category);
}
