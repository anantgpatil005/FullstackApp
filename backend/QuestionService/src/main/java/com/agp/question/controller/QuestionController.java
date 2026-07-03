package com.agp.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agp.question.entities.Question;
import com.agp.question.services.QuestionService;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping
	public Question createQuestion(@RequestBody Question entity) {
		Question savedQuestion = questionService.create(entity);
		return savedQuestion;
	}
	
	@GetMapping("/{questionId}")
	public Question getOneQuestion(@PathVariable Long questionId) {
		return questionService.getOne(questionId);
	}
	
	@GetMapping
	public List<Question> getAllQuestions() {
		return questionService.getAll();
	}
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsOfTheQuiz(@PathVariable Long quizId) {
		return questionService.getQuestionOfQuiz(quizId);
	}
	
	
	

}
