package com.shopping.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.entities.Orders;

public interface OrdersDao extends JpaRepository<Orders, Integer>{
	
    List<Orders> findByDateBefore(LocalDateTime today);
	
	List<Orders> findByDateBetween(LocalDateTime d1,LocalDateTime d2);

}
