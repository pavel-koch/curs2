package com.curswork.examen.servise.impl;

import com.curswork.examen.exception.IllegalQuestionAmountException;
import com.curswork.examen.exception.QuestionAlreadyAddException;
import com.curswork.examen.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.apache.commons.lang3.RandomUtils.nextInt;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Mock
    private JavaQuestionService javaQuestionService;

    @Test
    void getQuestions_CorrectParams() {
        List<Question> questions = List.of(
                new Question("Ready", "Go"),
                new Question("Steady", "Go"),
                new Question("Or", "No")
        );
        Question expected = questions.get(nextInt(0, questions.size()));

        when(javaQuestionService.getAll()).thenReturn(questions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(expected);

        //test
        Collection<Question> actual = examinerService.getQuestions(1);

        //check
        assertThat(actual).contains(expected);
    }

    @Test
    void getQuestions_Exceptions() {
        List<Question> questions = List.of(
                new Question("Ready", "Go"),
                new Question("Steady", "Go"),
                new Question("Or", "No")
        );
        Question expected = questions.get(nextInt(0, questions.size()));

        when(javaQuestionService.getAll()).thenThrow(IllegalQuestionAmountException.class);

        //test&&check
        assertThatExceptionOfType(IllegalQuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
    }
}