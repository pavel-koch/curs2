package com.curswork.examen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalQuestionAmountException extends RuntimeException{
    public IllegalQuestionAmountException(int amount) {
        super("[%s] - не существует в списке вопросов".formatted(amount));
    }
}
