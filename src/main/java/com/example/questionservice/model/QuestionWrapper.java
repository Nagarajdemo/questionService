package com.example.questionservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class QuestionWrapper {
    public int id;
    public String category;
    public String questionTitle;
    public String option1;

    public QuestionWrapper(int id, String category, String questionTitle, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.category = category;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    public String option2;
    public String option3;
    public String option4;


}
