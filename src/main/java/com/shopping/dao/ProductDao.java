package com.shopping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.Products;
import com.shopping.entities.User;


public interface ProductDao extends JpaRepository<Products, Integer>{
	List<Products> findByProductname(String productname);
	List<Products> findByBrand(String brand);
	List<Products> findByCategoryid(int categoryid);
	

}
