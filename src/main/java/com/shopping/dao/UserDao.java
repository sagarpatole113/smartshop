package com.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User findByEmail(String email);
	User save(User user);
	
}
