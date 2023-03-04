package com.shopping.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	@GeneratedValue(strategy = GenerationType.IDENTITY)        	 
	@Id
	private int cartid;
	private String price;
	private String quantity;
	private int userid;
	//@Column(name="productid")
	private int productid;
	
	/*new
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "productid")
	Products product;*/
	
	@ManyToOne
	@JoinColumn(name="productid",insertable=false, updatable=false)
	private Products productId;
	
	@OneToOne
	@JoinColumn(name="userid",insertable=false, updatable=false)
	private User userId;
	
	
	public Cart(){
	}
	
	public Cart(int cartid, String price, String quantity, int userid, int productid) {
		this.cartid = cartid;
		this.price = price;
		this.quantity = quantity;
		this.userid = userid;
		this.productid = productid;
	}
	
	public Cart(String price, String quantity, Products productId, User userId) {
		this.price = price;
		this.quantity = quantity;
		this.productId = productId;
		this.userId = userId;
	}
	public Cart(String price, String quantity, int userid, int productid) {
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
	
	public Products getProductId() {
		return productId;
	}

	public void setProductId(Products productId) {
		this.productId = productId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	public Products getSelectedProduct() {
		return productId;
	}

	public void setSelectedProduct(Products selectedProduct) {
		this.productId = selectedProduct;
	}


	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", price=" + price + ", quantity=" + quantity + ", userid=" + userid
				+ ", productid=" + productid + ", productId=" + productId + ", userId=" + userId + "]";
	}

	
	
	/*new
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}*/
	
	
	//new
	
	
}

