package com.ran.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ran.spring.batch.model.User;


public interface UserRepository extends JpaRepository<User,Integer>{}
