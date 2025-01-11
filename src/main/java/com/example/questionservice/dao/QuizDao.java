package com.example.questionservice.dao;

import com.example.questionservice.model.Question;
import com.example.questionservice.model.Quiz;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz, Integer> {


}
