package com.curswork.examen.servise.impl;

import com.curswork.examen.exception.QuestionAlreadyAddException;
import com.curswork.examen.exception.QuestionListIsEmptyException;
import com.curswork.examen.model.Question;
import com.curswork.examen.servise.QuestionServise;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import java.util.*;

import static java.util.Collections.unmodifiableCollection;

@Service
public class JavaQuestionService implements QuestionServise {
    private final Set<Question> javaQuestion = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question result = new Question(question, answer);
        if (javaQuestion.contains(result)) {
            throw new QuestionAlreadyAddException(question, answer);
        }
        javaQuestion.add(result);
        return result;
    }

    @Override
    public Question add(Question question) {
        if (javaQuestion.contains(question)) {
            throw new QuestionAlreadyAddException(question.getQuestion(), question.getAnswer());
        }
        javaQuestion.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question result = new Question(question, answer);
        javaQuestion.remove(result);
        return result;
    }

    @Override
    public Collection<Question> getAll() {
        return unmodifiableCollection(javaQuestion);
    }

    @Override
    public Question getRandomQuestion() {
        if (javaQuestion.isEmpty()) {
            throw new QuestionListIsEmptyException();
        }
        return new ArrayList<>(javaQuestion).get(nextInt(0, javaQuestion.size()));
    }
}
