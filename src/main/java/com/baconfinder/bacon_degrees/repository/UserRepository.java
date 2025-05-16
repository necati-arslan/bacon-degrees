package com.baconfinder.bacon_degrees.repository;
import com.baconfinder.bacon_degrees.model.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}