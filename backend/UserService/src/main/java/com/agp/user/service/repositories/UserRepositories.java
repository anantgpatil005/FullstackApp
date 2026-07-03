package com.agp.user.service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agp.user.service.entities.User;

public interface UserRepositories extends JpaRepository<User, String> {

	Optional<User> findByUserName(String userName);

}
