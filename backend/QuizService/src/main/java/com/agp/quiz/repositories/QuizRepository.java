package com.agp.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agp.quiz.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
