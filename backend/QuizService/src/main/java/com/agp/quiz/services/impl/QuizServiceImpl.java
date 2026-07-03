package com.agp.quiz.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agp.quiz.entities.Quiz;
import com.agp.quiz.repositories.QuizRepository;
import com.agp.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz saveQuiz(Quiz quiz) {
		Quiz savedQuiz = quizRepository.save(quiz);
		return savedQuiz;
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		Quiz fetchedQuiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("No quiz found"));
		return fetchedQuiz;
	}

	@Override
	public List<Quiz> getAllQuiz() {
		return quizRepository.findAll();
	}

}
