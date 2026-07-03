package com.agp.question.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agp.question.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	List<Question> findByQuizId(Long quizId);
}
