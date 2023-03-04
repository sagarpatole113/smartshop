package com.shopping.services;


import java.util.List;
import java.util.Map;

import com.shopping.entities.Cart;
import com.shopping.entities.Products;
import com.shopping.entities.User;

public interface CartService {
	
	String addItemToCart(int productid, String quantity, int userid);
	
	
    String deleteByUserid(int userid);
	
    List<Cart> getAllCartContents(int userid);
	
    Double getCartTotalAmt(int userid);
    
    List<Cart> getCartByUserid(int userid);
    
    List<Cart> removeCartByUserid(int cartid,int userid);
	  
    List<Cart> getProductidByUserid(int userid); 
    
    Cart findCartByCartid(int cartid);
    
    String deleteByCartid(int cartid); 
}
