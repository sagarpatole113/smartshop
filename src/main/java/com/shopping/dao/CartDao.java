package com.shopping.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopping.entities.Cart;
import com.shopping.entities.Products;
import com.shopping.entities.User;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{
	List<Cart> getProductidByUserid(int userid);
	String deleteByCartid(int cartid);
	//Products findByProductid(int productid);
	//User     findByUserid(int userid);
	
	//Cart findByUseridAndProductid(int userid, int productid);
	
	//@Query("select c from Cart c join fetch c.productid where c.userid.id = :id")
	
	@Query("select c from Cart c  where c.userid = :userid")
	List<Cart> findAllProductByUser(@Param("userid") int userid);
	
	
	@Query("select c from Cart c where c.userid=:userid")
	List<Cart> getCartByUserid(@Param("userid")int userid);
	 
	@Modifying
    @Transactional
	@Query("delete  from Cart c where c.cartid =:cartid   and c.userid=:userid")
	void deleteCartByCartidAndUserid(@Param("cartid")int cartid,@Param("userid")int userid);
	
	String deleteByUserid(int userid);
}
