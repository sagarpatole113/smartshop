package com.shopping.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entities.Cart;
import com.shopping.entities.Products;
import com.shopping.entities.User;
import com.shopping.model.CartDTO;
import com.shopping.model.ProductDTO;
import com.shopping.model.Response;
import com.shopping.model.ShowCartDTO;
import com.shopping.services.CartService;
import com.shopping.services.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartControllerImpl {
	
	@Autowired
	private CartService cartservice;
	
	// add to cart
//		@PostMapping("/addtocart")
//		public ResponseEntity<?> addToCart(@RequestBody HashMap<String, Integer> map) {
//			Integer productid = map.get("productid");
//			String quantity = Integer.toString(map.get("quantity"));
//			System.out.println("Productid: " + productid + " quantity: " + quantity);
//			Integer userid = map.get("userid");
//			return new ResponseEntity<>(cartservice.addItemToCart(productid, quantity, userid), HttpStatus.CREATED);
//		}
	// add to cart
    @GetMapping("/addtocart/{userid}/{productid}/{quantity}")
    public ResponseEntity<?> addToCart(@PathVariable int userid, @PathVariable int productid, @PathVariable String quantity ) {
    	System.out.println("hello");
    	System.out.println("Productid: " + productid + " quantity: " + quantity);
        return new ResponseEntity<>(cartservice.addItemToCart(productid, quantity, userid), HttpStatus.CREATED);
    }
		// view cart
		@GetMapping("/{userid}")
		public ResponseEntity<?> getCartContents(@PathVariable int userid) {

			// List<Cart> cartItems= cartService.getAllCartContents(userId);
			return new ResponseEntity<>(cartservice.getAllCartContents(userid), HttpStatus.OK);
		}
    
		
		@DeleteMapping("/delete/{userid}")
		public ResponseEntity<?> deleteItemFromCart(@PathVariable int userid) {
			System.out.println("in deleteItemFromCart: " + userid);
			return new ResponseEntity<>(cartservice.deleteByUserid(userid), HttpStatus.OK);

		}
		
		// cart total amount
		@GetMapping("/totalamt/{userid}")
		public ResponseEntity<?> getCartTotalAmount(@PathVariable int userid) {
			System.out.println("in getCartTotalAmount: " + userid);
			return new ResponseEntity<>(cartservice.getCartTotalAmt(userid), HttpStatus.OK);
		}
		
		@RequestMapping("/removeProductFromCart")
	  	public ResponseEntity<?> removeCartwithProductId(@RequestBody HashMap<String,Integer> map) {
			
                List<Cart> obj = cartservice.removeCartByUserid((map.get("cartid")),(map.get("userid")));
				return ResponseEntity.ok(obj);
			
	   }
		@GetMapping("/productidlist/{userid}")
		public ResponseEntity<?> getProductsByCategoryId(@PathVariable("userid") int userid) {
			List<Cart> list = cartservice.getProductidByUserid(userid);
			List<CartDTO> result = new ArrayList<CartDTO>();
			System.out.println(list);
			for (Cart cart : list)
				result.add( CartDTO.fromEntity(cart) );
			System.out.println(result);
			return Response.success(result);
		}

		@GetMapping("/showCart/{userid}")
	       public ResponseEntity<?> findCartAll(@PathVariable int userid) {
	           List<Cart> list = cartservice.getAllCartContents(userid);
	           Stream<ShowCartDTO> result = list.stream().map(cart -> ShowCartDTO.fromEntity(cart));
	           return Response.success(result);
	       }
		@DeleteMapping("/delete/cartid/{cartid}")
	       public ResponseEntity<?> deleteSelectedItemFromCart(@PathVariable int cartid) {
	           System.out.println("in deleteItemFromCart: " + cartid);
	           return new ResponseEntity<>(cartservice.deleteByCartid(cartid), HttpStatus.OK);

	       }
}
