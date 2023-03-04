package com.shopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.services.OrdersService;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderControllerImpl {
	
	@Autowired
	private OrdersService ordersService;
	
	@PostMapping("/placeorder/{userid}")
	public ResponseEntity<?> placeOrderFromCart(@PathVariable int userid) {
		return new ResponseEntity<>(ordersService.placeOrderForUser(userid), HttpStatus.ACCEPTED);
	}

}
