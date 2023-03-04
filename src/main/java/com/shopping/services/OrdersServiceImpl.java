package com.shopping.services;


import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.dao.CartDao;
import com.shopping.dao.OrderDetailsDao;
import com.shopping.dao.OrdersDao;
import com.shopping.dao.UserDao;
import com.shopping.entities.Cart;
import com.shopping.entities.OrderDetails;
import com.shopping.entities.OrderStatus;
import com.shopping.entities.Orders;
import com.shopping.entities.User;

@Transactional
@Service
public class OrdersServiceImpl implements OrdersService {
    
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CartService cartservice;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrdersDao orderDao;
	
	@Autowired
	private OrderDetailsDao orderdetailsDao;
	
	
	@Override
	public String placeOrderForUser(int userid) {
		// get all cart items for given user
				List<Cart> cartItems = cartDao.findAllProductByUser(userid);
				//Payment payment=new Payment();
				
				double total = 0.0;
				total = cartservice.getCartTotalAmt(userid);

				User user = userDao.findById(userid).get();

				Orders newOrder = new Orders(total, LocalDateTime.now(), OrderStatus.PENDING/* , LocalDateTime.now() */, user.getUserid());
				orderDao.save(newOrder);

				cartItems.forEach(item -> {
					orderdetailsDao.save(new OrderDetails(Double.parseDouble(item.getSelectedProduct().getPrice()), Integer.parseInt(item.getQuantity()), newOrder,
							item.getSelectedProduct()));
				});
				cartDao.deleteAll(cartItems);
				
				return "Order Placed Successfully!";
	}

}
