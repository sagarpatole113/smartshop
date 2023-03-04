package com.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.Category;


public interface CategoryDao extends JpaRepository<Category, Integer>{

}
