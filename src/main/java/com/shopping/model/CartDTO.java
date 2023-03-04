package com.shopping.model;

import org.springframework.beans.BeanUtils;
import com.shopping.entities.Cart;

public class CartDTO {
	private int cartid;
	private String price;
	private String quantity;
	private int userid;
	private int productid;
	CartDTO(){
		
	}
	public CartDTO(int cartid, String price, String quantity, int userid, int productid) {
		this.cartid = cartid;
		this.price = price;
		this.quantity = quantity;
		this.userid = userid;
		this.productid = productid;
	}
	
	public CartDTO(String price, String quantity, int userid, int productid) {
		this.price = price;
		this.quantity = quantity;
		this.userid = userid;
		this.productid = productid;
	}
	
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	
	@Override
	public String toString() {
		return "CartDTO [cartid=" + cartid + ", price=" + price + ", quantity=" + quantity
				+ ", userid=" + userid + ", productid=" + productid + "]";
	}
	public static CartDTO fromEntity(Cart cart) {
		CartDTO dto = new CartDTO();
		BeanUtils.copyProperties(cart, dto);
		return dto;
	}
	
	public static Cart toEntity(CartDTO dto){
		Cart cart = new Cart();
		BeanUtils.copyProperties(dto, cart);
		return cart;
	}

}
