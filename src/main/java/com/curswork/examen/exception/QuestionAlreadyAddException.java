package com.curswork.examen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAlreadyAddException extends RuntimeException {
    public QuestionAlreadyAddException(String question, String answer) {
        super("Вопрос: [%s] и ответ: [%s] - уже добавлены".formatted(question, answer));
    }
}
