package com.curswork.examen.servise;

import com.curswork.examen.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
