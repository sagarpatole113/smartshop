package com.shopping.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shopping.dao.CartDao;
import com.shopping.dao.ProductDao;
import com.shopping.dao.UserDao;
import com.shopping.entities.Cart;
import com.shopping.entities.Products;
import com.shopping.entities.User;

@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	@Autowired
	private  ProductDao productDao;
	
	@Autowired
	private  UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	

	@Override
	public String addItemToCart(int productid, String quantity, int userid) {
		
		User user = userDao.findById(userid).get();
		Products product = productDao.findById(productid).get();
		double c_amt = Integer.parseInt(quantity) * Integer.parseInt(product.getPrice());
		String price = Double.toString(c_amt); 
		//cartDao.save(new Cart(Integer.parseInt(quantity), product, user, price));
		cartDao.save(new Cart(price, quantity, user.getUserid(), product.getProductid()));
		return quantity + " " + "(s) of " + product.getProductname() + " added to cart";
	}

	@Override
	public String deleteByUserid(int userid) {
		cartDao.deleteByUserid(userid);
		return "Cart Details Deleted Successfully";
		
	}

	@Override
	   public List<Cart> getAllCartContents(int userid) {
	       
	       return cartDao.findAllProductByUser(userid);
	       
	   }
	
	@Override
	public Double getCartTotalAmt(int userid) {
		
		double cart_amt = 0.0;
		List<Cart> cart = cartDao.findAllProductByUser(userid);
		for (Cart cart2 : cart) {
			cart_amt = cart_amt + Double.parseDouble(cart2.getPrice());
		}
		System.out.println(cart_amt);
		// System.out.println(cart);
		return cart_amt;
	}
	
	@Override
	public List<Cart> getCartByUserid(int userid) {
		return cartDao.getCartByUserid(userid);
	}
	
	
	
    @Override
	public List<Cart> removeCartByUserid(int cartid, int userid) {
		cartDao.deleteCartByCartidAndUserid(cartid, userid);
		return this.getCartByUserid(userid);
	}

	@Override
	public List<Cart> getProductidByUserid(int userid) {
		return cartDao.getProductidByUserid(userid);
	}

	@Override
	   public Cart findCartByCartid(int cartid) {
	       Optional<Cart> cart = cartDao.findById(cartid);
	       return cart.orElse(null);
	   }
	
	@Override
	   public String deleteByCartid(int cartid) {
	       cartDao.deleteByCartid(cartid);
	       return "Cart Item Deleted Successfully";
	       }
	

}
