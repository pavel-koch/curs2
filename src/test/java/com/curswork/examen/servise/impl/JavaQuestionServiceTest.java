package com.curswork.examen.servise.impl;

import com.curswork.examen.exception.QuestionAlreadyAddException;
import com.curswork.examen.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.apache.commons.lang3.RandomUtils.nextInt;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void add_WhenCorrectParams_ThanAddQuestion() {
        String question = "Ready?";
        String answer = "Go";
        Question expected = new Question(question, answer);

        // test
        Question actual = javaQuestionService.add(question, answer);
        // check
        assertThat(actual).isNotNull();
        assertThat(actual.getQuestion()).isEqualTo(question);
        assertThat(actual.getAnswer()).isEqualTo(answer);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void add_WhenException() {
        String question = "Ready?";
        String answer = "Go";
        javaQuestionService.add(question, answer);
        // test&&check
        assertThatExceptionOfType(QuestionAlreadyAddException.class)
                .isThrownBy(() -> javaQuestionService.add(question, answer));
    }

    @Test
    void testAdd_Object_WhenCorrectParams_ThanAddQuestion() {
        String question = "Ready?";
        String answer = "Go";
        Question expected = new Question(question, answer);

        // test
        Question actual = javaQuestionService.add(expected);
        // check
        assertThat(actual).isNotNull();
        assertThat(actual.getQuestion()).isEqualTo(question);
        assertThat(actual.getAnswer()).isEqualTo(answer);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void add_Object_WhenException() {
        String question = "Ready?";
        String answer = "Go";
        Question question1 = new Question(question, answer);
        javaQuestionService.add(question1);
        // test&&check
        assertThatExceptionOfType(QuestionAlreadyAddException.class)
                .isThrownBy(() -> javaQuestionService.add(question1));
    }

    @Test
    void remove() {
        String question = "Ready?";
        String answer = "Go";
        Question expected = new Question(question, answer);

        // test
        Question actual = javaQuestionService.remove(question, answer);
        // check
        assertThat(actual).isEqualTo(expected);
        Collection<Question> questions = javaQuestionService.getAll();
        assertThat(questions).isEmpty();
    }

    @Test
    void getAll() {
        List<Question> expected = new ArrayList<>();
        for (int i = 0; i < nextInt(1, 11); i++) {
            javaQuestionService.add(new Question("a".repeat(i), "b".repeat(i)));
            expected.add(new Question("a".repeat(i), "b".repeat(i)));
        }
        // test
        Collection<Question> actual = javaQuestionService.getAll();

        // check
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void getRandomQuestion() {
        List<Question> expected = new ArrayList<>();
        for (int i = 0; i < nextInt(1, 11); i++) {
            javaQuestionService.add(new Question("a".repeat(i), "b".repeat(i)));
            expected.add(new Question("a".repeat(i), "b".repeat(i)));
        }
        Question actual = javaQuestionService.getRandomQuestion();
        assertThat(expected).contains(actual);
    }
}