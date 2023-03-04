package com.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.entities.OrderDetails;

public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer>{

	
	//List<OrderProduct> findAllByOrderId(Integer id);

}
