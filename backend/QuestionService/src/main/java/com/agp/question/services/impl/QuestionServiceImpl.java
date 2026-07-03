package com.agp.question.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.agp.question.entities.Question;
import com.agp.question.repositories.QuestionRepository;
import com.agp.question.services.QuestionService;


public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question create(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Question getOne(Long questionId) {
		return questionRepository.findById(questionId).orElseThrow(()-> new RuntimeException("No question found"));
	}

	@Override
	public List<Question> getAll() {
		return questionRepository.findAll();
	}

	@Override
	public List<Question> getQuestionOfQuiz(Long quizId) {
		return questionRepository.findByQuizId(quizId);
	}

}
