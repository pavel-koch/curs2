package com.curswork.examen.servise.impl;

import com.curswork.examen.exception.IllegalQuestionAmountException;
import com.curswork.examen.model.Question;
import com.curswork.examen.servise.ExaminerService;
import com.curswork.examen.servise.QuestionServise;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionServise questionServise;

    public ExaminerServiceImpl(QuestionServise questionServise) {
        this.questionServise = questionServise;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> allQuestions = questionServise.getAll();
        if (allQuestions.size() < amount || amount < 0) {
            throw new IllegalQuestionAmountException(amount);
        } else if (allQuestions.size() == amount) {
            return allQuestions;
        }

        Set<Question> resultSet = new HashSet<>();
        while (resultSet.size() < amount) {
            resultSet.add(questionServise.getRandomQuestion());
        }
        return resultSet;
    }
}
