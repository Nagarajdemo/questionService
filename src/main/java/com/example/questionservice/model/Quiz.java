package com.example.questionservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public List<Question> getQuestions() {
        return questions;
    }

    @ManyToMany
    private  List<Question> questions;
}
