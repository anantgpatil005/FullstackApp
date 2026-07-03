package com.agp.question.services;

import java.util.List;

import com.agp.question.entities.Question;

public interface QuestionService {
	
	public Question create(Question question);
	
	public Question getOne(Long questionId);
	
	public List<Question> getAll();
	
	public List<Question> getQuestionOfQuiz(Long quizId);

}
