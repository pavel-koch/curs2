package com.curswork.examen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestionListIsEmptyException extends RuntimeException {
    public QuestionListIsEmptyException() {
        super("В базе нет никаких вопросов");
    }
}
