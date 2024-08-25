package com.curswork.examen.controller;

import com.curswork.examen.model.Question;
import com.curswork.examen.servise.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RestController()
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions (@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
