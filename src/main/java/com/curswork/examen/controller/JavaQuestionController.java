package com.curswork.examen.controller;

import com.curswork.examen.model.Question;
import com.curswork.examen.servise.QuestionServise;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final QuestionServise questionServise;

    public JavaQuestionController(QuestionServise questionServise) {
        this.questionServise = questionServise;
    }

    @GetMapping("/java/add")
    public Question add(@RequestParam("question") String question,
                        @RequestParam("answer") String answer) {
        return questionServise.add(question, answer);
    }

    @GetMapping("/java/remove")
    public Question remove(@RequestParam("question") String question,
                           @RequestParam("answer") String answer) {
        return questionServise.remove(question, answer);
    }

    @GetMapping("/java")
    public Collection<Question> getAll() {
        return questionServise.getAll();
    }
}
