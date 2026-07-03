package com.agp.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agp.quiz.entities.Quiz;
import com.agp.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping
	public Quiz create(@RequestBody Quiz quiz) {
		return quizService.saveQuiz(quiz);
	}

	@GetMapping("/{id}")
	public Quiz getQuiz(@PathVariable Long id) {
		return quizService.getQuiz(id);
	}
	
	@GetMapping
	public List<Quiz> getAllQuiz(){
		return quizService.getAllQuiz();
	}
}
