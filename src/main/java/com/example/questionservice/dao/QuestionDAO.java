package com.example.questionservice.dao;

import com.example.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
    List<Question> getQuestionByCategory(String category);
    @Query(value="SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery=true)
    List<Question> getRandomQuestions(String category, int numQ);

}
