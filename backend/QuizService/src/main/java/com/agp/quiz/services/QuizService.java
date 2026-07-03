package com.agp.quiz.services;

import java.util.List;

import com.agp.quiz.entities.Quiz;

public interface QuizService {
	public Quiz saveQuiz(Quiz quiz);
	
	public Quiz getQuiz(Long quizId);
	
	public List<Quiz> getAllQuiz();

}
