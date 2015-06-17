package com.terry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terry.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}
