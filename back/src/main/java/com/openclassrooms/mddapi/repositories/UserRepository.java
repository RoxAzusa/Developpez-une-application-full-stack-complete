package com.openclassrooms.mddapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openclassrooms.mddapi.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
	Optional<UserModel> findUserByEmail(String email);
	Optional<UserModel> findByUserName(String userName);
}
