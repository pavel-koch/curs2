package com.curswork.examen.servise;

import com.curswork.examen.model.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionServise {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
